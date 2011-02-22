package org.fao.teldir.util;

public class StringUtils {

	public static String emptyIfNull(String maybeNull) {
		return maybeNull != null ? maybeNull : "";
	}

	public static String retainOnlyNumbers(String string) {
		return string.replaceAll("[^0-9]","");
	}

}
