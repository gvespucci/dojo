package org.fao.teldir.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.fao.teldir.config.Configuration;

@SuppressWarnings("serial")
public class ConfigurationInitServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		InputStream propertiesStream = config.getServletContext().getResourceAsStream("/WEB-INF/config.properties");
		try {
			Configuration.loadFrom(propertiesStream);
		} catch (IOException e) {
			throw new ServletException(e);
		}
	}
}
