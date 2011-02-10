package org.fao.teldir.tags;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class Response {
	
	public static final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	private List<Contact> teldir = new ArrayList<Contact>();

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
}
