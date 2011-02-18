/**
 * 
 */
package org.fao.teldir.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.fao.teldir.core.Response;
import org.fao.teldir.logging.ApplicationLogger;
import org.fao.teldir.marshall.Marshaller;
import org.fao.teldir.marshall.MarshallerFactory;
import org.fao.teldir.parser.TelephoneDirectoryResponseParser;

/**
 * 
 */
public class TelephoneDirectoryServlet extends HttpServlet {
	
	private Logger logger = Logger.getLogger(TelephoneDirectoryServlet.class);
	
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
		final String methodName = "[processRequest()] ";
		try {
			String urlToCall = FAO_INTRANET_SERVLET+req.getQueryString();
			
			ApplicationLogger.debug(logger, methodName, urlToCall);
			ApplicationLogger.debug(logger, methodName, "URI "+req.getRequestURI());
			ApplicationLogger.debug(logger, methodName, "URL "+req.getRequestURL().toString());
			ApplicationLogger.debug(logger, methodName, "Query "+req.getQueryString());
			ApplicationLogger.debug(logger, methodName, "Context "+req.getContextPath());

			URL url = new URL(urlToCall);
	        URLConnection urlConnection = url.openConnection();
	        urlConnection.connect();
			
	        resp.setCharacterEncoding("UTF-8");

	        Marshaller marshaller = MarshallerFactory.marshaller(req.getParameter("format"));
			
	        resp.setContentType(marshaller.contentType());

	        new TelephoneDirectoryResponseParser().parse(
	        		new InputStreamReader(urlConnection.getInputStream()), 
	        		resp.getWriter(), 
	        		marshaller, 
	        		req.getRequestURL()+"?"+req.getQueryString(), XPathFactory.newInstance().newXPath());

		} catch (Exception e) {
			e.printStackTrace(); //	Exception managing?
				try {
					Marshaller marshaller = MarshallerFactory.marshaller(Marshaller.XML);
					marshaller.marshall(new Response(), resp.getWriter());
				} catch (Exception ex) {
					ex.printStackTrace();
				}

		}
	}
}

