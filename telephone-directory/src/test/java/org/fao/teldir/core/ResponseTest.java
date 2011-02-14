package org.fao.teldir.core;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.InputStreamReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.fao.teldir.common.TestFiles;
import org.fao.teldir.common.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

public class ResponseTest {

	private XPath xpath;

	@Before
	public void setUp() {
		xpath = XPathFactory.newInstance().newXPath();
	}
	@Test
	public void noPagesFromEmptyDocument() throws Exception {
		Document empty = TestUtils.domFrom("");
		Response response = new Response().fillFrom(empty, xpath);
		assertThat(response, is(equalTo(new Response())));
	}
	
	@Test
	public void noPagesFromNullDocument() throws Exception {
		Response response = new Response().fillFrom(null, xpath);
		assertThat(response, is(equalTo(new Response())));
	}
	
	@Test
	public void sixPages_FirstPageChosen() throws Exception {
		Document document = TestUtils.domFrom(TestUtils.extractHtmlCodeFrom(new InputStreamReader(getClass().getResourceAsStream(TestFiles.MULTIPAGE_FIRST_PAGE_HTM))));
		
		Response actualResponse = new Response().fillFrom(document, xpath);
		
		Pages pages = PagesBuilder.somePages().withNumberOfPages("6").build();
		Response expectedResponse = ResponseBuilder.aResponse().withPages(pages).build();
		
		assertThat(actualResponse, is(equalTo(expectedResponse)));
	}
	
	@Test
	public void sixPages_MiddlePageChosen() throws Exception {
		Document document = TestUtils.domFrom(TestUtils.extractHtmlCodeFrom(new InputStreamReader(getClass().getResourceAsStream(TestFiles.MULTIPAGE_MIDDLE_PAGE_HTM))));
		
		Response actualResponse = new Response().fillFrom(document, xpath);
		
		Pages pages = PagesBuilder.somePages().withNumberOfPages("6").build();
		Response expectedResponse = ResponseBuilder.aResponse().withPages(pages).build();
		
		assertThat(actualResponse, is(equalTo(expectedResponse)));
	}
	
	@Test
	public void sixPages_LastPageChosen() throws Exception {
		Document document = TestUtils.domFrom(TestUtils.extractHtmlCodeFrom(new InputStreamReader(getClass().getResourceAsStream(TestFiles.MULTIPAGE_LAST_PAGE_HTM))));
		
		Response actualResponse = new Response().fillFrom(document, xpath);
		
		Pages pages = PagesBuilder.somePages().withNumberOfPages("6").build();
		Response expectedResponse = ResponseBuilder.aResponse().withPages(pages).build();
		
		assertThat(actualResponse, is(equalTo(expectedResponse)));
	}

}
