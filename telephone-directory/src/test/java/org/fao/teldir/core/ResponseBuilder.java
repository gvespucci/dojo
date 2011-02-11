package org.fao.teldir.core;

import java.util.ArrayList;
import java.util.List;

import org.fao.teldir.core.Contact;
import org.fao.teldir.core.Response;

public class ResponseBuilder {

	private List<Contact> contacts = new ArrayList<Contact>();

	public static ResponseBuilder aResponse() {
		return new ResponseBuilder();
	}

	public Response build() {
		Response response = new Response();
		for (Contact contact : contacts) {
			response.add(contact);
		}
		return response;
	}

	public ResponseBuilder withContact(Contact contact) {
		this.contacts.add(contact);
		return this;
	}

}
