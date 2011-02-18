package org.fao.teldir.core;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class ResponseBuilder {

	private final List<Contact> contacts = new ArrayList<Contact>();
	private Pages pages;
	private Document document;
	private String message;

	public static ResponseBuilder aResponse() {
		return new ResponseBuilder();
	}

	public Response build() throws Exception {
		Response response = new Response();
		if(document != null) {
			response.fillFrom(this.document, XPathFactory.newInstance().newXPath(), "/yabba-dabba-doo");
		} else {
			response.addMessage(this.message);
			for (Contact contact : contacts) {
				response.add(contact);
			}
			response.add(this.pages);
		}
		return response;
	}

	public ResponseBuilder withContact(Contact contact) {
		this.contacts.add(contact);
		return this;
	}

	public ResponseBuilder withPages(Pages pages) {
		this.pages = pages;
		return this;
	}

	public ResponseBuilder fromDocument(Document document) {
		this.document = document;
		return this;
	}

	public ResponseBuilder withMessage(String message) {
		this.message = message;
		return this;
	}

}
