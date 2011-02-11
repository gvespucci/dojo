package org.fao.teldir.parser;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.fao.teldir.core.Response;
import org.fao.teldir.marshall.MarshallFormat;
import org.fao.teldir.marshall.Marshaller;
import org.fao.teldir.marshall.MarshallerFactory;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;


public class TelephoneDirectoryResponseParser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 
	 * @param reader TODO
	 * @param writer
	 * @param jsonOutput TODO
	 * @return
	 * @throws Exception
	 */
	public Response parse(Reader reader, Writer writer) throws Exception {
		return this.parse(reader, writer, MarshallerFactory.marshaller(MarshallFormat.XML));
	}
	
	/**
	 * 
	 * @param reader TODO
	 * @param writer
	 * @param marshaller TODO
	 * @return
	 * @throws Exception
	 */
	public Response parse(Reader reader, Writer writer, Marshaller marshaller) throws Exception {
		Response response = new Response();

		if(reader != null && writer != null && marshaller != null) {
			
			String htmlCode = extractHtmlCodeFrom(reader);

			Document cleanedHtml = cleanIt(htmlCode);
			
			response.fillFrom(cleanedHtml);
			response.marshallTo(writer, marshaller);
		}
		
		return response;
	}

	private Document cleanIt(String htmlCode) throws UnsupportedEncodingException {
		Tidy htmlCleaner = new Tidy();
		Document cleanedHtml = htmlCleaner.parseDOM(new ByteArrayInputStream(htmlCode.getBytes("UTF-8")), null);
		return cleanedHtml;
	}

	private String extractHtmlCodeFrom(Reader reader) throws IOException {
		String inputLine;
		StringBuilder htmlBuilder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(reader);
		while ((inputLine = bufferedReader.readLine()) != null) {
			htmlBuilder.append(inputLine);
		}
		reader.close();
		String htmlCode = htmlBuilder.toString();
		return htmlCode;
	}

}
