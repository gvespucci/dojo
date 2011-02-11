package org.fao.teldir.marshall;

import java.io.IOException;
import java.io.Writer;

import org.fao.teldir.core.Contact;
import org.fao.teldir.core.Response;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class MarshallerFactory {
	
	public static Marshaller marshaller(MarshallFormat format) {
		if(MarshallFormat.JSON.equals(format)) {
			return new JsonMarshaller();
		} else 
		if(MarshallFormat.XML.equals(format)) {
			return new XmlMarshaller();
		}
		return new NullMarshaller();
	}

	public static XStream getMarshaller(Writer writer, boolean jsonOutput) throws IOException {
		XStream xstream = new XStream();
		if(jsonOutput) {
			xstream = new XStream(new JettisonMappedXmlDriver());
		}
	
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations( new Class[]{Response.class, Contact.class});
		
		if(!jsonOutput) {
			writer.write(XmlMarshaller.XML_HEADER);
		}
		return xstream;
	}

}
