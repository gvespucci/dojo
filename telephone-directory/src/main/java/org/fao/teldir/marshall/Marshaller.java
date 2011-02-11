package org.fao.teldir.marshall;

import java.io.Writer;

import org.fao.teldir.core.Contact;
import org.fao.teldir.core.Response;

import com.thoughtworks.xstream.XStream;

public abstract class Marshaller {
	
	protected XStream xstream;

	public abstract void marshall(Response response, Writer writer) throws Exception;
	public abstract String contentType();

	protected void initXStream() {
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations( new Class[]{Response.class, Contact.class});
	}
}
