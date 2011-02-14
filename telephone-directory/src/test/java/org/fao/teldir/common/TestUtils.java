package org.fao.teldir.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.junit.Ignore;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

@Ignore
public class TestUtils {
	public static String extractHtmlCodeFrom(Reader reader) throws IOException {
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

	public static Document domFrom(String htmlCode) throws UnsupportedEncodingException {
		Tidy htmlCleaner = new Tidy();
		Document dom = htmlCleaner.parseDOM(new ByteArrayInputStream(htmlCode.getBytes("UTF-8")), null);
		return dom;
	}
}
