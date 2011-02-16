package org.fao.teldir.parser;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.xpath.XPathFactory;

import org.fao.teldir.common.TestFiles;
import org.fao.teldir.core.Contact;
import org.fao.teldir.core.ContactBuilder;
import org.fao.teldir.core.Pages;
import org.fao.teldir.core.PagesBuilder;
import org.fao.teldir.core.Response;
import org.fao.teldir.core.ResponseBuilder;
import org.fao.teldir.marshall.MarshallFormat;
import org.fao.teldir.marshall.MarshallerFactory;
import org.junit.Before;
import org.junit.Test;

public class TelephoneDirectoryResponseParserTest {
	
	private TelephoneDirectoryResponseParser theParser;
	
	@Before
	public void setUp() {
		theParser = new TelephoneDirectoryResponseParser();
	}

	@Test public void 
	exactlyOneResponse() throws Exception {
		URL url = getClass().getResource(TestFiles.EXACTLY_ONE_RESPONSE_HTM); 
		URLConnection urlConnection = url.openConnection();
		
		Response parsedResponse = theParser.parse(
				new InputStreamReader(urlConnection.getInputStream()), 
				new PrintWriter(System.out, true),
				MarshallerFactory.marshaller(MarshallFormat.NULL), "/yabba-dabba-du", XPathFactory.newInstance().newXPath());
		
		Contact vespucci = ContactBuilder.aContact()
			.withNameDept("VESPUCCI, Giorgio (CIOK)")
			.withTitle("Computer information systems s").withRoom("B159").withExtension("56175")
			.build();
		Response expectedResponse = ResponseBuilder.aResponse().withContact(vespucci).build();
	
		assertThat(parsedResponse, is(equalTo(expectedResponse)));
	}
	
	@Test public void 
	multipleResponse_NoPage() throws Exception {
		URL url = getClass().getResource(TestFiles.MULTIPLE_RESPONSE_NO_PAGE_HTM); 
		URLConnection urlConnection = url.openConnection();
		
		Response parsedResponse = theParser.parse(
				new InputStreamReader(urlConnection.getInputStream()), 
				new PrintWriter(System.out, true),
				MarshallerFactory.marshaller(MarshallFormat.NULL), "/yabba-dabba-du", XPathFactory.newInstance().newXPath());
		
		Contact maddalena = ContactBuilder.aContact()
			.withNameDept("DI GIORGIO, Maddalena (AGNA)").withTitle("CLERK TYPIST").withRoom("C251").withExtension("55413")
			.build();
		
		Contact lanzarone = ContactBuilder.aContact()
			.withNameDept("LANZARONE, Giorgio (CIOK)").withTitle("INFORMATION MANAGEMENT OFF.").withRoom("A203").withExtension("53805")
			.build();
		
		Contact pala = ContactBuilder.aContact()
			.withNameDept("PALA, Giorgio (TCES)").withTitle("CLERK").withRoom("C653").withExtension("55649")
			.build();
		
		Contact zazzara = ContactBuilder.aContact()
			.withNameDept("ZAZZARA, Giorgio (ESAE)").withTitle("Administration/finance/ manage").withRoom("C302").withExtension("53040")
			.build();
		
		Response expectedResponse = ResponseBuilder.aResponse()
			.withContact(maddalena)
			.withContact(lanzarone)
			.withContact(pala)
			.withContact(zazzara)
			.build();
	
		assertThat(parsedResponse, is(equalTo(expectedResponse)));
	}
	
	@Test public void 
	multipleResponse_WithPages() throws Exception {
		URL url = getClass().getResource(TestFiles.MULTIPAGE_RESPONSE_HTM);
		URLConnection urlConnection = url.openConnection();
		
		
		Contact maddalena = ContactBuilder.aContact()
			.withNameDept("DI GIORGIO, Maddalena (AGNA)").withTitle("CLERK TYPIST").withRoom("C251").withExtension("55413")
			.build();
		
		Contact lanzarone = ContactBuilder.aContact()
			.withNameDept("LANZARONE, Giorgio (CIOK)").withTitle("INFORMATION MANAGEMENT OFF.").withRoom("A203").withExtension("53805")
			.build();
		
		Contact pala = ContactBuilder.aContact()
			.withNameDept("PALA, Giorgio (TCES)").withTitle("CLERK").withRoom("C653").withExtension("55649")
			.build();
		
		Contact zazzara = ContactBuilder.aContact()
			.withNameDept("ZAZZARA, Giorgio (ESAE)").withTitle("Administration/finance/ manage").withRoom("C302").withExtension("53040")
			.build();
		
		Pages pages = PagesBuilder.somePages()
			.withNumberOfPages("6")
			.withCurrentPage("1")
			.withNextPage("2")
			.build();
		
		Response expectedResponse = ResponseBuilder.aResponse()
			.withPages(pages)
			.withContact(maddalena)
			.withContact(lanzarone)
			.withContact(pala)
			.withContact(zazzara)
			.build();

		Response actualResponse = theParser.parse(
				new InputStreamReader(urlConnection.getInputStream()), 
				new PrintWriter(System.out, true),
				MarshallerFactory.marshaller(MarshallFormat.NULL), "/yabba-dabba-du", XPathFactory.newInstance().newXPath());
	
		assertThat(actualResponse, is(equalTo(expectedResponse)));
		
	}

	@Test public void 
	shouldReturnAnEmptyResponseWhenReaderIsNull() throws Exception {
		Response response = theParser.parse(null, 
				new PrintWriter(System.out, true),
				MarshallerFactory.marshaller(MarshallFormat.NULL), "/yabba-dabba-du", XPathFactory.newInstance().newXPath());
		assertThat(response, is(equalTo(new Response())));
	}
	
	@Test public void 
	shouldReturnAnEmptyResponseWhenWriterIsNull() throws Exception {
		Response response = theParser.parse(
				new InputStreamReader(getClass().getResourceAsStream(TestFiles.EXACTLY_ONE_RESPONSE_HTM)), 
				null, 
				MarshallerFactory.marshaller(MarshallFormat.NULL), "/yabba-dabba-du", XPathFactory.newInstance().newXPath());
		assertThat(response, is(equalTo(new Response())));
	}
	
	@Test public void 
	shouldReturnAnEmptyResponseWhenMarshallerIsNull() throws Exception {
		Response response = theParser.parse(
				new InputStreamReader(getClass().getResourceAsStream(TestFiles.EXACTLY_ONE_RESPONSE_HTM)), 
				new PrintWriter(System.out, true), 
				null, "/yabba-dabba-du", XPathFactory.newInstance().newXPath());
		assertThat(response, is(equalTo(new Response())));
	}
	
	public static void main(String[] args) {
		String intranetSearch = searchFor("vespucci");
		try {
		    
			URL url = new URL(intranetSearch);
	        URLConnection urlConnection = url.openConnection();
			
	        new TelephoneDirectoryResponseParser().parse(
	        		new InputStreamReader(urlConnection.getInputStream()), 
	        		new PrintWriter(System.out, true), 
	        		MarshallerFactory.marshaller(MarshallFormat.JSON), "/yabba-dabba-du", XPathFactory.newInstance().newXPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String searchFor(String searchString) {
		return "http://intranet.fao.org/IntranetServlet?"+"searchType=teldir&pg=teldir&search_string="+searchString;
	}

}
