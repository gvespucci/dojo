package org.fao.teldir.marshall;

import java.io.Writer;

import org.fao.teldir.core.Response;

class NullMarshaller extends Marshaller {

	@Override
	public void marshall(Response response, Writer writer) throws Exception {
		// NOP
	}

	@Override
	public String contentType() {
		return "text/html";
	}

}
