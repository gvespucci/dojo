package org.fao.teldir.marshall;


public class MarshallerFactory {
	
	public static Marshaller marshaller(String format) {
		if(Marshaller.JSON.equals(format)) {
			return new JsonMarshaller();
		} else 
		if(Marshaller.XML.equals(format)) {
			return new XmlMarshaller();
		}
		return new NullMarshaller();
	}
}
