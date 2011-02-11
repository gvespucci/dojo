package org.fao.teldir.main;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.fao.teldir.tags.Contact;
import org.fao.teldir.tags.Response;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

import com.thoughtworks.xstream.XStream;

public class TelephoneDirectoryResponseParser {

	private static final String NAME_DEPT = "nameDept";
	private static final String EXTENSION = "extension";
	private static final String ROOM_NUMBER = "roomNumber";
	private static final String TITLE = "title";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param reader TODO
	 * @param writer
	 * @return
	 * @throws Exception
	 */
	public Response parse(Reader reader, Writer writer) throws Exception {
		Response response = new Response();

		if(reader != null && writer != null) {
			
			String htmlCode = extractHtmlCodeFrom(reader);

			Document cleanedHtml = cleanIt(htmlCode);
			
			response = fillResponseFrom(cleanedHtml);
			
			serializeTo(response, writer);
		}
		
		return response;
	}

	private void serializeTo(Response response, Writer writer) {
		XStream xstream = new XStream();
		xstream.processAnnotations( new Class[]{Response.class, Contact.class});
		xstream.toXML(response, writer);
	}

	private Response fillResponseFrom(Document cleanedHtml) throws XPathExpressionException {
		Response response = new Response();
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		NodeList staffMembers = (NodeList) xpath.evaluate("//table[@class='staffMember']", cleanedHtml, XPathConstants.NODESET);
		
		for (int i = 0; i < staffMembers.getLength(); i++) {
			Node aStaffMember = staffMembers.item(i);
			
			String name = xpath.evaluate(staffMembersWith(NAME_DEPT), aStaffMember);
			String title = xpath.evaluate(staffMembersWith(TITLE), aStaffMember);
			String roomNumber = xpath.evaluate("substring-after("+staffMembersWith(ROOM_NUMBER)+", 'Room ')", aStaffMember);
			String extension = xpath.evaluate("substring-after("+staffMembersWith(EXTENSION)+", 'Ext. ')", aStaffMember);
			
			Contact contact = new Contact().withNameDept(name).withTitle(title).withRoom(roomNumber).withExtension(extension);
		
			response.add(contact);
		}
		
		return response;
	}

	private Document cleanIt(String htmlCode) throws UnsupportedEncodingException {
		Tidy htmlCleaner = new Tidy();
		Document cleanedHtml = htmlCleaner.parseDOM(new ByteArrayInputStream(htmlCode.getBytes("UTF-8")), null);
		return cleanedHtml;
	}

	private String extractHtmlCodeFrom(Reader reader) throws IOException {
		String inputLine;
		StringBuilder htmlBuilder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(reader);
		while ((inputLine = bufferedReader.readLine()) != null) {
			htmlBuilder.append(inputLine);
		}
		reader.close();
		String htmlCode = htmlBuilder.toString();
		return htmlCode;
	}

	private String staffMembersWith(String className) {
		return "tr/td[@class='"+className+"']/p[normalize-space()]";
	}
}
