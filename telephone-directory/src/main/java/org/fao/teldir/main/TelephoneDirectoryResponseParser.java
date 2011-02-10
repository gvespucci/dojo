package org.fao.teldir.main;



import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLConnection;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.fao.teldir.tags.Contact;
import org.fao.teldir.tags.Response;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.tidy.Tidy;

import com.thoughtworks.xstream.XStream;

public class TelephoneDirectoryResponseParser {

	private static final String NAME_DEPT = "nameDept";
	private static final boolean RECURSIVELY = true;
	private static final String EXTENSION = "extension";
	private static final String ROOM_NUMBER = "roomNumber";
	private static final String TITLE = "title";
	private static final String STAFF_MEMBER = "staffMember";
	private static final String CLASS = "class";
	
	private static final String STAFF_MEMBER_EXPRESSION = "//table[@class='"+STAFF_MEMBER+"']";
	private static final String NAME_DEPT_EXPRESSION = "//td[@class='nameDept']/p[normalize-space()]";
	private static final String TITLE_EXPRESSION = "//td[@class='title']";
	private static final String ROOM_EXPRESSION = "//td[@class='room']";
	private static final String EXTENSION_EXPRESSION = "//td[@class='extension']";
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param urlConnection
	 * @param writer TODO
	 * @throws Exception
	 */
	public Response parseWithHtmlParser(URLConnection urlConnection, PrintWriter writer) throws Exception {
		
		Response response = new Response();

		if(urlConnection != null && writer != null) {
			
			XStream xstream = new XStream();
			//		xstream.alias("response", Response.class);
			//		xstream.alias("contact", Contact.class);
			xstream.processAnnotations( new Class[]{Response.class, Contact.class});

			
			Parser parser = new Parser(urlConnection);

			NodeList allNodes = parser.parse(null); 

			NodeList tables = allNodes.extractAllNodesThatMatch(new TagNameFilter(new TableTag().getTagName()), RECURSIVELY);

			NodeList staffMemberTables  = tables.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, STAFF_MEMBER));
			
			NodeList staffMemberTableColumns  = staffMemberTables.extractAllNodesThatMatch(new TagNameFilter(new TableColumn().getTagName()), RECURSIVELY);

			NodeList nameDeptColumns = staffMemberTableColumns.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, NAME_DEPT));
			for(int i=0, n = nameDeptColumns.size(); i<n; i++) {
				String staffMemberName = nameDeptColumns.elementAt(i).getFirstChild().getFirstChild().toHtml();
				Contact contact = new Contact().withNameDept(staffMemberName.replace("\r\n", ""));
				response.add(contact);
			}

			//		    NodeList titleTDs = tds.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, TITLE));
			//		    NodeList roomNumberTDs = tds.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, ROOM_NUMBER));
			//		    NodeList extensionTDs = tds.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, EXTENSION));

			xstream.toXML(response, writer);

		}
		
		return response;
	}
	
	public Response parse(URLConnection urlConnection, PrintWriter writer) throws Exception {
		Response response = new Response();

		if(urlConnection != null && writer != null) {
			
			BufferedReader urlConnectionReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			StringBuilder htmlBuilder = new StringBuilder();
			while ((inputLine = urlConnectionReader.readLine()) != null) {
				htmlBuilder.append(inputLine);
			}
			urlConnectionReader.close();
			String htmlCode = htmlBuilder.toString();

			Tidy beautifier = new Tidy();
			Document tidyHtml = beautifier.parseDOM(new ByteArrayInputStream(htmlCode.getBytes("UTF-8")), null);
			
			XPath xpath = XPathFactory.newInstance().newXPath();
			XPathExpression staffMemberExpression = xpath.compile(STAFF_MEMBER_EXPRESSION);
			org.w3c.dom.NodeList staffMembers = (org.w3c.dom.NodeList)staffMemberExpression.evaluate(tidyHtml, XPathConstants.NODESET);
			System.out.println(staffMembers.getLength()+" tables"); 
			
//			XPathExpression nameDeptExpression = xpath.compile(staffMembersWith(NAME_DEPT));
//			org.w3c.dom.NodeList nameAndDepartments = (org.w3c.dom.NodeList)nameDeptExpression.evaluate(tidyHtml, XPathConstants.NODESET);
//			System.out.println("nameDepts "+nameAndDepartments.getLength());
//			
//			XPathExpression titleExpression = xpath.compile(staffMembersWith(TITLE));
//			org.w3c.dom.NodeList titles = (org.w3c.dom.NodeList)titleExpression.evaluate(tidyHtml, XPathConstants.NODESET);
//			System.out.println("titles "+titles.getLength());
//
//			XPathExpression roomExpression = xpath.compile(staffMembersWith(ROOM_NUMBER));
//			org.w3c.dom.NodeList rooms = (org.w3c.dom.NodeList)roomExpression.evaluate(tidyHtml, XPathConstants.NODESET);
//			System.out.println("rooms "+rooms.getLength());
//			
//			XPathExpression extensionExpression = xpath.compile(staffMembersWith(EXTENSION));
//			org.w3c.dom.NodeList extensions = (org.w3c.dom.NodeList)extensionExpression.evaluate(tidyHtml, XPathConstants.NODESET);
//			System.out.println("extensions "+extensions.getLength());
//			
//			
//			XPathExpression nameExpression = xpath.compile("td[@class='"+NAME_DEPT+"']/p[normalize-space()]");
//			org.w3c.dom.Node names = (org.w3c.dom.Node)xpath.evaluate("//td[@class='"+NAME_DEPT+"']/p[normalize-space()]", tidyHtml, XPathConstants.NODE);

			for (int i = 0; i < staffMembers.getLength(); i++) {
				Node aStaffMember = staffMembers.item(i);
				
				
				String name = xpath.evaluate(staffMembersWith(NAME_DEPT), aStaffMember);
				System.out.println("name "+name);
				
				String title = xpath.evaluate("tr/td[@class='"+TITLE+"']/p[normalize-space()]", aStaffMember);
				System.out.println("title "+title);
				
				String roomNumber = xpath.evaluate("tr/td[@class='"+ROOM_NUMBER+"']/p[normalize-space()]", aStaffMember);
				System.out.println("room No. "+roomNumber);
				
				String extension = xpath.evaluate("tr/td[@class='"+EXTENSION+"']/p[normalize-space()]", aStaffMember);
				System.out.println("extension "+extension);
				
				Contact contact = new Contact().withNameDept(name).withTitle(title).withRoom(roomNumber).withExtension(extension);
			
				response.add(contact);
			}
			
		}
		
		return response;
	}

	private String staffMembersWith(String className) {
		return "tr/td[@class='"+className+"']/p[normalize-space()]";
	}
}
