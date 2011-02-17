package org.fao.teldir.core;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import lombok.ToString;

import org.apache.log4j.Logger;
import org.fao.teldir.logging.ApplicationLogger;
import org.fao.teldir.marshall.Marshaller;
import org.fao.teldir.util.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("response")
@ToString(exclude="logger")
public class Response {
	
	@XStreamOmitField
	private Logger logger = Logger.getLogger(getClass());
	
	public static final String RESPONSE_PAGE = "respg";
	private Pages pages;
	private List<Contact> teldir;

	public static final String TITLE = "title";
	public static final String ROOM_NUMBER = "roomNumber";
	public static final String EXTENSION = "extension";
	public static final String NAME_DEPT = "nameDept";

	public void add(Contact aContact) {
		if(this.teldir == null) {
			this.teldir = new ArrayList<Contact>();
		}
		this.teldir.add(aContact);
	}

	public void add(Pages pages) {
		this.pages = pages;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pages == null) ? 0 : pages.hashCode());
		result = prime * result + ((teldir == null) ? 0 : teldir.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (pages == null) {
			if (other.pages != null)
				return false;
		} else if (!pages.equals(other.pages))
			return false;
		if (teldir == null) {
			if (other.teldir != null)
				return false;
		} else if (!teldir.equals(other.teldir))
			return false;
		return true;
	}

	/**
	 * 
	 * @param document
	 * @param xpath TODO
	 * @param urlForPages TODO
	 * @return
	 * @throws Exception 
	 */
	public Response fillFrom(Document document, XPath xpath, String urlForPages) throws Exception {
		if(document != null && xpath != null) { 
			addContactsFrom(document, xpath);
			addPagesFrom(document, xpath, urlForPages);
		}
		return this;
	}

	private void addPagesFrom(Document document, XPath xpath, String urlForPages) throws XPathExpressionException {
		
		int numberOfPageLink = numberOfPageLinkIn(document, xpath);

		if(numberOfPageLink > 0) {
			
			int numberOfPages = calculateRightNumberOfPages(document, xpath, numberOfPageLink);

			String currentPageNumber = currentPageNumberFrom(document, xpath);
			String previousPageNumber = calculatePreviousPageNumberFrom(currentPageNumber);
			String nextPageNumber = calculateNextPageNumberFrom(numberOfPages, currentPageNumber);
			String baseUrl = baseUrlFrom(urlForPages);
			
			this.add(
					new Pages()
						.withNumberOfPages(""+numberOfPages)
						.withCurrentPage(currentPageNumber)
						.withPreviousPage(previousPageNumber)
						.withNextPage(nextPageNumber)
						.withBaseUrl(baseUrl));
		}
	}

	private String calculateNextPageNumberFrom(int numberOfPages, String currentPageNumber) {
		return isLastPage(numberOfPages, currentPageNumber) ? "" : ""+(Integer.parseInt(currentPageNumber)+1);
	}

	private String calculatePreviousPageNumberFrom(String currentPageNumber) {
		return isFirstPage(currentPageNumber) ? "" : ""+(Integer.parseInt(currentPageNumber)-1);
	}

	private String currentPageNumberFrom(Document document, XPath xpath) throws XPathExpressionException {
		String textCharactersExpression = "//p[@class='pageSelector']/text()[translate(., '&#x20;&#x09;&#x0a;&#x0d;&#xa0;', '')]";
		NodeList textItems = (NodeList)xpath.evaluate(textCharactersExpression, document, XPathConstants.NODESET);
		
		StringBuilder textCollector = new StringBuilder();
		for (int i = 0; i < textItems.getLength(); i++) {
			Node aText = textItems.item(i);
			textCollector.append(aText.getNodeValue());
		}
		String currentPageNumber = StringUtils.retainOnlyNumbers(textCollector.toString());
		return currentPageNumber;
	}

	private int calculateRightNumberOfPages(Document document, XPath xpath, int numberOfPages) throws XPathExpressionException {
		String previousLinkExpression = pageSelectors()+"/a[text()='< Prev']";
		Node prevAnchor = (Node)xpath.evaluate(previousLinkExpression, document, XPathConstants.NODE);
		if(prevAnchor != null) {
			numberOfPages--;			
		}

		String nextLinkExpression = pageSelectors()+"/a[text()='Next >']";
		Node nextAnchor = (Node)xpath.evaluate(nextLinkExpression, document, XPathConstants.NODE);
		if(nextAnchor != null) {
			numberOfPages--;
		}
		numberOfPages++;
		return numberOfPages;
	}

	private String baseUrlFrom(String urlForPages) throws XPathExpressionException {
		return new UrlManipulator(urlForPages).putAsLast(RESPONSE_PAGE);
	}

	private boolean isLastPage(int numberOfPages, String currentPageNumber) {
		return Integer.parseInt(currentPageNumber) == numberOfPages;
	}

	private boolean isFirstPage(String currentPageNumber) {
		return Integer.parseInt(currentPageNumber) == 1;
	}

	private int numberOfPageLinkIn(Document document, XPath xpath) throws XPathExpressionException {
		NodeList pageSelectorAnchors = (NodeList) xpath.evaluate(pageSelectors()+"/a", document, XPathConstants.NODESET);
		int totalNumberOfAnchors = pageSelectorAnchors.getLength();
		
		ApplicationLogger.debug(logger, "numberOfPageLinkIn()", "Number of pages "+totalNumberOfAnchors);		
		
		return totalNumberOfAnchors;
	}

	private String pageSelectors() {
		return "//p[@class='pageSelector']";
	}

	/**
	 * 
	 * @param document
	 * @param xpath
	 * @throws XPathExpressionException
	 */
	private void addContactsFrom(Document document, XPath xpath) throws XPathExpressionException {
		NodeList staffMembers = (NodeList) xpath.evaluate("//table[@class='staffMember']", document, XPathConstants.NODESET);

		int staffMembersFound = staffMembers.getLength();
		
		ApplicationLogger.debug(logger, "addContacsFrom()", "Staff Members found "+staffMembersFound);
		
		for (int i=0; i < staffMembersFound; i++) {
			Node aStaffMember = staffMembers.item(i);

			String name = xpath.evaluate(staffMembersWith(NAME_DEPT), aStaffMember);
			String title = xpath.evaluate(staffMembersWith(TITLE), aStaffMember);
			String roomNumber = xpath.evaluate("substring-after("+staffMembersWith(ROOM_NUMBER)+", 'Room ')", aStaffMember);
			String extension = xpath.evaluate("substring-after("+staffMembersWith(EXTENSION)+", 'Ext. ')", aStaffMember);

			Contact contact = new Contact().withNameDept(name).withTitle(title).withRoom(roomNumber).withExtension(extension);

			this.add(contact);
		}
	}
	
	private String staffMembersWith(String className) {
		return "tr/td[@class='"+className+"']/p[normalize-space()]";
	}

	public void marshallTo(Writer writer, Marshaller marshaller) throws Exception {
		marshaller.marshall(this, writer);
	}
	
	public String currentPage() {
		return this.pages.current();
	}
	
	public String previousPage() {
		return this.pages.previous();
	}
	
	public String nextPage() {
		return this.pages.next();
	}
	
	public String howManyPages() {
		return this.pages.howMany();
	}
	
	public String baseUrl() {
		return this.pages.url();
	}

}
