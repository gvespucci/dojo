package org.fao.teldir.marshall;


public class MarshallerFactory {
	
	public static Marshaller marshaller(String format) {
		if(Marshaller.JSON.equalsIgnoreCase(format)) {
			return new JsonMarshaller();
		} else 
		if(Marshaller.XML.equalsIgnoreCase(format)) {
			return new XmlMarshaller();
		}
		return new XmlMarshaller();
	}

	public static Marshaller nullMarshaller() {
		return new NullMarshaller();
	}
}
