package org.fao.teldir.main;



import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLConnection;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
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
	 * @param urlConnection
	 * @param writer
	 * @return
	 * @throws Exception
	 */
	public Response parse(URLConnection urlConnection, PrintWriter writer) throws Exception {
		Response response = new Response();

		if(urlConnection != null && writer != null) {
			
			XStream xstream = new XStream();
			xstream.processAnnotations( new Class[]{Response.class, Contact.class});
			
			BufferedReader urlConnectionReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			StringBuilder htmlBuilder = new StringBuilder();
			while ((inputLine = urlConnectionReader.readLine()) != null) {
				htmlBuilder.append(inputLine);
			}
			urlConnectionReader.close();
			String htmlCode = htmlBuilder.toString();

			Tidy htmlCleaner = new Tidy();
			Document cleanedHtml = htmlCleaner.parseDOM(new ByteArrayInputStream(htmlCode.getBytes("UTF-8")), null);
			
			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList staffMembers = (NodeList) xpath.evaluate("//table[@class='staffMember']", cleanedHtml, XPathConstants.NODESET);
			
			for (int i = 0; i < staffMembers.getLength(); i++) {
				Node aStaffMember = staffMembers.item(i);
				
				String name = xpath.evaluate(staffMembersWith(NAME_DEPT), aStaffMember);
				String title = xpath.evaluate(staffMembersWith(TITLE), aStaffMember);
				String roomNumber = xpath.evaluate(staffMembersWith(ROOM_NUMBER), aStaffMember);
				String extension = xpath.evaluate(staffMembersWith(EXTENSION), aStaffMember);
				
				Contact contact = new Contact().withNameDept(name).withTitle(title).withRoom(roomNumber).withExtension(extension);
			
				response.add(contact);
			}
			
			xstream.toXML(response, writer);
			
		}
		
		return response;
	}

	private String staffMembersWith(String className) {
		return "tr/td[@class='"+className+"']/p[normalize-space()]";
	}
}
