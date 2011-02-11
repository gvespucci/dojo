package org.fao.teldir.core;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

public class ResponseTest {

	@Test
	public void testFillFrom() {
		fail("Not yet implemented");
	}
	
	private Document domFrom(String htmlCode) throws UnsupportedEncodingException {
		Tidy htmlCleaner = new Tidy();
		Document dom = htmlCleaner.parseDOM(new ByteArrayInputStream(htmlCode.getBytes("UTF-8")), null);
		return dom;
	}

}
