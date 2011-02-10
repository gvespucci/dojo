package org.fao.teldir.main;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.fao.teldir.tags.Contact;
import org.fao.teldir.tags.ContactBuilder;
import org.fao.teldir.tags.Response;
import org.fao.teldir.tags.ResponseBuilder;
import org.junit.Ignore;
import org.junit.Test;

public class TelephoneDirectoryResponseParserTest {
	
	@Test public void 
	exactlyOneResponse() throws Exception {
		URL url = new URL("file:///C:/dev/workspaces/dojo/telephone-directory/src/test/resources/exactly-one-response.htm");
		URLConnection urlConnection = url.openConnection();
		
		Response parsedResponse = new TelephoneDirectoryResponseParser().parse(urlConnection, new PrintWriter(System.out, true));
		
		Contact vespucci = ContactBuilder.aContact()
			.withNameDept("VESPUCCI, Giorgio (CIOK)")
			.withTitle("Computer information systems s").withRoom("B159").withExtension("56175")
			.build();
		Response expectedResponse = ResponseBuilder.aResponse().withContact(vespucci).build();
	
		assertThat(parsedResponse, is(equalTo(expectedResponse)));
	}
	
	@Test public void 
	multipleResponseNoPage() throws Exception {
		URL url = new URL("file:///C:/dev/workspaces/dojo/telephone-directory/src/test/resources/multiple-response-no-page.htm");
		URLConnection urlConnection = url.openConnection();
		
		Response parsedResponse = new TelephoneDirectoryResponseParser().parse(urlConnection, new PrintWriter(System.out, true));
		
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
	shouldReturnsAnEmptyResponseWhenURLConnectionIsNull() throws Exception {
		Response response = new TelephoneDirectoryResponseParser().parse(null, new PrintWriter(System.out, true));
		assertThat(response, is(equalTo(new Response())));
	}
	
	@Test public void 
	shouldReturnsAnEmptyResponseWhenPrintWriterIsNull() throws Exception {
		Response response = new TelephoneDirectoryResponseParser().parse(null, null);
		assertThat(response, is(equalTo(new Response())));
	}
	
	public static void main(String[] args) {
		String intranetSearch = searchFor("vespucci");
		try {
		    
			URL url = new URL(intranetSearch);
	        URLConnection urlConnection = url.openConnection();
			
	        new TelephoneDirectoryResponseParser().parse(urlConnection, new PrintWriter(System.out, true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String searchFor(String searchString) {
		return "http://intranet.fao.org/IntranetServlet?"+"searchType=teldir&pg=teldir&search_string="+searchString;
	}

}
