/**
 * 
 */
package org.fao.teldir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fao.teldir.main.TelephoneDirectoryResponseParser;


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
		resp.setContentType("text/xml");
		try {
			PrintWriter out = resp.getWriter();
			
			String parameterSequence = buildParameterSequence(req, out);
			
			String completeUrl = FAO_INTRANET_SERVLET+parameterSequence;
			URL url = new URL(completeUrl);
			System.out.println(completeUrl);
	        URLConnection urlConnection = url.openConnection();
	        urlConnection.connect();
			
	        new TelephoneDirectoryResponseParser().parse(urlConnection, resp.getWriter());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param req
	 * @param out
	 * @return
	 */
	private String buildParameterSequence(HttpServletRequest req, PrintWriter out) {
		StringBuilder builder = new StringBuilder();
		@SuppressWarnings("unchecked")
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		for (Iterator<String> iterator = parameterMap.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			String value = ((String[]) parameterMap.get( key ))[ 0 ];
			
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

