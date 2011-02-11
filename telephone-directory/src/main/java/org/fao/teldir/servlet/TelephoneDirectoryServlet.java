/**
 * 
 */
package org.fao.teldir.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fao.teldir.marshall.MarshallFormat;
import org.fao.teldir.marshall.Marshaller;
import org.fao.teldir.marshall.MarshallerFactory;
import org.fao.teldir.parser.TelephoneDirectoryResponseParser;

/**
 * 
 */
public class TelephoneDirectoryServlet extends HttpServlet {
	
	public static final String FAO_INTRANET_SERVLET = "http://intranet.fao.org/IntranetServlet?";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 */
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String parameterSequence = buildParameterSequenceFrom(req);
			
			String completeUrl = FAO_INTRANET_SERVLET+parameterSequence;
			System.out.println(completeUrl);
			URL url = new URL(completeUrl);
	        URLConnection urlConnection = url.openConnection();
	        urlConnection.connect();
			
	        resp.setCharacterEncoding("UTF-8");

	        Marshaller marshaller = MarshallerFactory.marshaller(MarshallFormat.XML);
			
	        resp.setContentType(marshaller.contentType());

	        new TelephoneDirectoryResponseParser().parse(
	        		new InputStreamReader(urlConnection.getInputStream()), 
	        		resp.getWriter(), 
	        		marshaller);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param req
	 * @return
	 */
	private String buildParameterSequenceFrom(HttpServletRequest req) {
		StringBuilder builder = new StringBuilder();
		@SuppressWarnings("unchecked")
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		for (Iterator<String> iterator = parameterMap.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			String value = (parameterMap.get( key ))[ 0 ];
			
			String keyValueSequence = key+"="+value;
			
			builder.append(keyValueSequence);
			if(iterator.hasNext()) {
				builder.append("&");
			}
		}
		return builder.toString();
	}

	public static String searchFor(String searchString) {
		return FAO_INTRANET_SERVLET+"searchType=teldir&pg=teldir&search_string="+searchString;
	}
}

