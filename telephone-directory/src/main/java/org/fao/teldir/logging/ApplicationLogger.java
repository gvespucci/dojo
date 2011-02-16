package org.fao.teldir.logging;

import org.apache.log4j.Logger;

public final class ApplicationLogger {
	public static void debug(Logger logger, String methodName, String message) {
		if(logger.isDebugEnabled()) {
			logger.debug(methodName+" - "+message);
		}
	}

	public static void methodBegin(Logger logger, String methodName) {
		logMethodPhase(logger, methodName, " - BEGIN");
	}

	private static void logMethodPhase(Logger logger, String methodName, String phase) {
		if(logger.isInfoEnabled()) {
			logger.info(methodName+phase);
		}
	}
	
	public static void methodEnd(Logger logger, String methodName) {
		logMethodPhase(logger, methodName, " - END");
	}
}
