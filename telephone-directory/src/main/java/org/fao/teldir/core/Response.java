package org.fao.teldir.core;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.fao.teldir.marshall.Marshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class Response {
	
	private final List<Contact> teldir = new ArrayList<Contact>();

	public static final String TITLE = "title";
	public static final String ROOM_NUMBER = "roomNumber";
	public static final String EXTENSION = "extension";
	public static final String NAME_DEPT = "nameDept";

	public void add(Contact aContact) {
		this.teldir.add(aContact);
	}
	
	public void writeTo(PrintWriter writer) {
		writer.println(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (teldir == null) {
			if (other.teldir != null)
				return false;
		} else if (!teldir.equals(other.teldir))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.teldir.toString();
	}

	public void fillFrom(Document document) {
		try {
			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList staffMembers = (NodeList) xpath.evaluate("//table[@class='staffMember']", document, XPathConstants.NODESET);
			
			for (int i = 0; i < staffMembers.getLength(); i++) {
				Node aStaffMember = staffMembers.item(i);
				
				String name = xpath.evaluate(staffMembersWith(NAME_DEPT), aStaffMember);
				String title = xpath.evaluate(staffMembersWith(TITLE), aStaffMember);
				String roomNumber = xpath.evaluate("substring-after("+staffMembersWith(ROOM_NUMBER)+", 'Room ')", aStaffMember);
				String extension = xpath.evaluate("substring-after("+staffMembersWith(EXTENSION)+", 'Ext. ')", aStaffMember);
				
				Contact contact = new Contact().withNameDept(name).withTitle(title).withRoom(roomNumber).withExtension(extension);
			
				this.add(contact);
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
	
	private String staffMembersWith(String className) {
		return "tr/td[@class='"+className+"']/p[normalize-space()]";
	}

	public void marshallTo(Writer writer, Marshaller marshaller) throws Exception {
		marshaller.marshall(this, writer);
	}
}
