package org.fao.teldir.tags;

import java.util.ArrayList;
import java.util.List;

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
