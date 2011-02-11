package org.fao.teldir.core;

import java.util.ArrayList;
import java.util.List;

public class ResponseBuilder {

	private final List<Contact> contacts = new ArrayList<Contact>();
	private Pages pages = new Pages();

	public static ResponseBuilder aResponse() {
		return new ResponseBuilder();
	}

	public Response build() {
		Response response = new Response();
		for (Contact contact : contacts) {
			response.add(contact);
		}
		response.add(this.pages);
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

}
