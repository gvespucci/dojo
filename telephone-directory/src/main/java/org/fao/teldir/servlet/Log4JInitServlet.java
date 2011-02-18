package org.fao.teldir.servlet;
import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;


@SuppressWarnings("serial")
public class Log4JInitServlet extends HttpServlet {
	private static final String LOG4J_XML_LOCATION = "log4j-xml-location";

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Log4JInitServlet is initializing log4j");
		String log4jLocation = config.getInitParameter(LOG4J_XML_LOCATION);

		ServletContext sc = config.getServletContext();

		if (log4jLocation == null) {
			System.err.println("*** No "+LOG4J_XML_LOCATION+" init param, so initializing log4j with BasicConfigurator");
			BasicConfigurator.configure();
		} else {
			String webAppPath = sc.getRealPath("/");
			String log4jProp = webAppPath + System.getProperty("file.separator")+ log4jLocation;
			File log4jConfigurationFile = new File(log4jProp);
			if (log4jConfigurationFile.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
				DOMConfigurator.configureAndWatch(log4jProp);
			} else {
				System.err.println("*** " + log4jProp + " file not found, so initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			}
		}
	}

}
