package org.fao.teldir.core;

import org.fao.teldir.util.StringUtils;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("contact")
public class Contact {

	private String nameDept = "";
	private String title = "";
	private String roomNumber = "";
	private String extension = "";

	public Contact withNameDept(String nameDept) {
		this.nameDept = StringUtils.emptyIfNull(nameDept);
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((extension == null) ? 0 : extension.hashCode());
		result = prime * result
				+ ((nameDept == null) ? 0 : nameDept.hashCode());
		result = prime * result
				+ ((roomNumber == null) ? 0 : roomNumber.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Contact other = (Contact) obj;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (nameDept == null) {
			if (other.nameDept != null)
				return false;
		} else if (!nameDept.equals(other.nameDept))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public Contact withTitle(String title) {
		this.title = StringUtils.emptyIfNull(title);
		return this;
	}
	
	public Contact withRoom(String roomNumber) {
		this.roomNumber = StringUtils.emptyIfNull(roomNumber);
		return this;
	}
	public Contact withExtension(String extension) {
		this.extension = StringUtils.emptyIfNull(extension);
		return this;
	}
	
	@Override
	public String toString() {
		return "["+this.nameDept+", "+this.title+", "+this.roomNumber+", "+this.extension+"]";
	}
	
}
