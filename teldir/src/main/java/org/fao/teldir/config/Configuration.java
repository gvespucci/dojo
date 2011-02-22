package org.fao.teldir.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.fao.teldir.logging.ApplicationLogger;
import org.fao.teldir.marshall.Marshaller;

public class Configuration {
	
	public static final String FAO_INTRANET_SERVLET = "http://intranet.fao.org/IntranetServlet?";

	public static final String RESPONSE_FORMAT = "response.format";

	public static final String REQUEST_URL = "request.url";

	private static Logger logger = Logger.getLogger(Configuration.class);
	
	private static Properties defaults = new Properties();
	private static Properties properties = new Properties(defaults);
	
	static {
		defaults.setProperty(REQUEST_URL, FAO_INTRANET_SERVLET);
		defaults.setProperty(RESPONSE_FORMAT, Marshaller.XML);
	}

	public static void loadFrom(InputStream propertiesStream) throws IOException {
		final String methodName = "[loadFrom()]";

		ApplicationLogger.debug(logger, methodName, 
			"Default configuration is        : "+defaults);

		properties.load(propertiesStream);
		
		ApplicationLogger.debug(logger, methodName, 
			"Loaded application configuration: "+properties);
	}

	public static String intranetServletUrl() {
		return properties.getProperty(REQUEST_URL);
	}

	public static String responseFormat() {
		return properties.getProperty(RESPONSE_FORMAT);
	}

}
