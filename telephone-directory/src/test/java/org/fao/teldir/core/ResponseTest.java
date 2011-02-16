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
	private Document fourthPageChosenDocument;
	private Document lastPagChosenDocument;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		xpath = XPathFactory.newInstance().newXPath();
		firstPageChosenDocument = domFrom(TestFiles.MULTIPAGE_FIRST_PAGE_HTM);
		fourthPageChosenDocument = domFrom(TestFiles.MULTIPAGE_MIDDLE_PAGE_HTM);
		lastPagChosenDocument = domFrom(TestFiles.MULTIPAGE_LAST_PAGE_HTM);
		baseUrl = "/yabba-dabba-doo";
	}
	
	private Document domFrom(String resourceName) throws UnsupportedEncodingException, IOException {
		return TestUtils.domFrom(TestUtils.extractHtmlCodeFrom(new InputStreamReader(getClass().getResourceAsStream(resourceName))));
	}
	
	@Test
	public void emptyResponseFromNullXPath() throws Exception {
		Response response = new Response().fillFrom(firstPageChosenDocument, null, baseUrl);
		assertThat(response, is(equalTo(new Response())));
	}
	
	@Test
	public void noPagesFromEmptyDocument() throws Exception {
		Document empty = TestUtils.domFrom("");
		Response response = new Response().fillFrom(empty, xpath, baseUrl);
		assertThat(response, is(equalTo(new Response())));
	}
	
	@Test
	public void emptyResponseFromNullDocument() throws Exception {
		Response response = new Response().fillFrom(null, xpath, baseUrl);
		assertThat(response, is(equalTo(new Response())));
	}
	
	@Test
	public void pageNumberWhenFirstPageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(firstPageChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.currentPage(), is(equalTo("1")));
	}
	
	@Test
	public void pageNumberWhenMiddlePageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(fourthPageChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.howManyPages(), is(equalTo("6")));
	}
	
	@Test
	public void pageNumberWhenLastPageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(lastPagChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.howManyPages(), is(equalTo("6")));
	}
	
	@Test
	public void currentPageWhenFirstPageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(firstPageChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.currentPage(), is(equalTo("1")));
	}
	
	@Test
	public void currentPageWhenFourthPageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(fourthPageChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.currentPage(), is(equalTo("4")));
	}
	
	@Test
	public void currentPageWhenLastPageChosen() throws Exception {
		Response actualResponse = new Response().fillFrom(lastPagChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.currentPage(), is(equalTo("6")));
	}
	
	@Test
	public void previousPageWhenFirstPageSelected() throws Exception {
		Response actualResponse = new Response().fillFrom(firstPageChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.previousPage(), is(equalTo("")));
	}

	@Test
	public void previousPageWhenFourthPageSelected() throws Exception {
		Response actualResponse = new Response().fillFrom(fourthPageChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.previousPage(), is(equalTo("3")));
	}
	
	@Test
	public void previousPageWhenLastPageSelected() throws Exception {
		Response actualResponse = new Response().fillFrom(lastPagChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.previousPage(), is(equalTo("5")));
	}

	@Test
	public void nextPageWhenFirstPageSelected() throws Exception {
		Response actualResponse = new Response().fillFrom(firstPageChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.nextPage(), is(equalTo("2")));
	}
	
	@Test
	public void nextPageWhenFourthPageSelected() throws Exception {
		Response actualResponse = new Response().fillFrom(fourthPageChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.nextPage(), is(equalTo("5")));
	}

	@Test
	public void nextPageWhenLastPageSelected() throws Exception {
		Response actualResponse = new Response().fillFrom(lastPagChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.nextPage(), is(equalTo("")));
	}
	
	@Test
	public void baseUrl() throws Exception {
		Response actualResponse = new Response().fillFrom(firstPageChosenDocument, xpath, baseUrl);
		assertThat(actualResponse.baseUrl(), is(equalTo(baseUrl+"?searchType=teldir&pg=teldir&search_string=561"+"&respg=")));
	}

}
