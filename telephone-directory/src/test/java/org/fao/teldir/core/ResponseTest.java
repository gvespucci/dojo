package org.fao.teldir.core;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.fao.teldir.common.TestFiles;
import org.fao.teldir.common.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

public class ResponseTest {

	private XPath xpath;
	private Document firstPageChosenDocument;
	private Document middlePagechosenDocument;
	private Document lastPagChosenDocument;

	@Before
	public void setUp() throws Exception {
		xpath = XPathFactory.newInstance().newXPath();
		firstPageChosenDocument = domFrom(TestFiles.MULTIPAGE_FIRST_PAGE_HTM);
		middlePagechosenDocument = domFrom(TestFiles.MULTIPAGE_MIDDLE_PAGE_HTM);
		lastPagChosenDocument = domFrom(TestFiles.MULTIPAGE_LAST_PAGE_HTM);
	}
	private Document domFrom(String resourceName)
			throws UnsupportedEncodingException, IOException {
		return TestUtils.domFrom(TestUtils.extractHtmlCodeFrom(new InputStreamReader(getClass().getResourceAsStream(resourceName))));
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
	public void pageNumberWhenFirstPageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(firstPageChosenDocument, xpath);
		
		Pages pages = PagesBuilder.somePages().withNumberOfPages("6").withCurrentPage("1").build();
		Response expectedResponse = ResponseBuilder.aResponse().withPages(pages).build();
		
		assertThat(actualResponse, is(equalTo(expectedResponse)));
	}
	
	@Test
	public void pageNumberWhenMiddlePageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(middlePagechosenDocument, xpath);
		
		Pages pages = PagesBuilder.somePages().withNumberOfPages("6").withCurrentPage("4").build();
		Response expectedResponse = ResponseBuilder.aResponse().withPages(pages).build();
		
		assertThat(actualResponse, is(equalTo(expectedResponse)));
	}
	
	@Test
	public void pageNumberWhenLastPageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(lastPagChosenDocument, xpath);
		
		Pages pages = PagesBuilder.somePages().withNumberOfPages("6").withCurrentPage("6").build();
		Response expectedResponse = ResponseBuilder.aResponse().withPages(pages).build();
		
		assertThat(actualResponse, is(equalTo(expectedResponse)));
	}
	
	@Test
	public void currentPageWhenFirstPageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(firstPageChosenDocument, xpath);
		
		Pages pages = PagesBuilder.somePages().withNumberOfPages("6").withCurrentPage("1").build();
		Response expectedResponse = ResponseBuilder.aResponse().withPages(pages).build();
		
		assertThat(actualResponse, is(equalTo(expectedResponse)));
	}

}
