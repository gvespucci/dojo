package org.fao.teldir.marshall;

import java.io.Writer;

import org.fao.teldir.core.Response;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

class JsonMarshaller extends Marshaller {
	
	JsonMarshaller() {
		xstream = new XStream(new JettisonMappedXmlDriver());
		initXStream();
	}

	@Override
	public void marshall(Response response, Writer writer) {
		xstream.toXML(response, writer);
	}

	@Override
	public String contentType() {
		return "application/json";
	}
}
