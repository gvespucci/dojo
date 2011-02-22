package org.fao.teldir.core;

public class UrlManipulator {

	private String urlToManipulate;

	public UrlManipulator(String urlToManipulate) {
		this.urlToManipulate = urlToManipulate;
	}

	public String putAsLast(String parameterToPutAsLast) {
		String urlWithoutPageParameter = removeParameter(parameterToPutAsLast);
		
		
		return urlWithoutPageParameter+"&"+parameterToPutAsLast+"=";
	}

	private String removeParameter(String stringToCut) {
		return this.urlToManipulate.replaceAll("&"+stringToCut+"=[0-9]*", "");
	}

}
