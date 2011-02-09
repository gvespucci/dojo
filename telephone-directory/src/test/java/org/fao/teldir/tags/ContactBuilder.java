package org.fao.teldir.tags;

public class ContactBuilder {
	public static ContactBuilder aContact() {
		return new ContactBuilder();
	}

	private String nameDept = "";
	private String title = "";
	private String room = "";
	private String extension = "";
	
	public ContactBuilder withNameDept(String name) {
		this.nameDept = name;
		return this;
	}
	
	public Contact build() {
		Contact contact = new Contact();
		contact.withNameDept(this.nameDept).withTitle(this.title).withRoom(this.room).withExtension(this.extension);
		return contact;
	}

	public ContactBuilder withTitle(String title) {
		this.title = title;
		return this;
	}

	public ContactBuilder withRoom(String roomNumber) {
		this.room = roomNumber;
		return this;
	}

	public ContactBuilder withExtension(String extension) {
		this.extension = extension;
		return this;
	}
}
