package org.fao.teldir.marshall;

import java.io.Writer;

import org.fao.teldir.core.Response;

import com.thoughtworks.xstream.XStream;

class XmlMarshaller extends Marshaller {

	public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	
	XmlMarshaller() {
		xstream = new XStream();
		initXStream();
	}

	@Override
	public void marshall(Response response, Writer writer) throws Exception {
		writer.write(XmlMarshaller.XML_HEADER);
		xstream.toXML(response, writer);
	}

	@Override
	public String contentType() {
		return "text/xml";
	}

}
