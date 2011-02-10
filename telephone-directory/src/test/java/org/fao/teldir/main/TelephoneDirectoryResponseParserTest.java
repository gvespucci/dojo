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
	exactlyOneResponseTidy() throws Exception {
		URL url = new URL("file:///C:/dev/workspaces/dojo/telephone-directory/src/test/resources/exactly-one-response.htm");
		URLConnection urlConnection = url.openConnection();
		
		Response parsedResponse = new TelephoneDirectoryResponseParser().parse(urlConnection, new PrintWriter(System.out, true));
		
		Contact vespucci = ContactBuilder.aContact()
			.withNameDept("VESPUCCI, Giorgio  (CIOK)")
			.withTitle("Computer information systems s").withRoom("B159").withExtension("56175")
			.build();
		Response expectedResponse = ResponseBuilder.aResponse().withContact(vespucci).build();
	
		assertThat(parsedResponse, is(equalTo(expectedResponse)));
	}

	@Test public void 
	shouldReturnsAnEmptyResponseWhenURLConnectionIsNull_HtmParser() throws Exception {
		Response response = new TelephoneDirectoryResponseParser().parse(null, new PrintWriter(System.out, true));
		assertThat(response, is(equalTo(new Response())));
	}
	
	@Test public void 
	shouldReturnsAnEmptyResponseWhenPrintWriterIsNull_HtmlParser() throws Exception {
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
