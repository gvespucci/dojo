package org.fao.teldir.util;

public class StringUtils {

	public static String emptyIfNull(String maybeNull) {
		return maybeNull != null ? maybeNull : "";
	}

}
