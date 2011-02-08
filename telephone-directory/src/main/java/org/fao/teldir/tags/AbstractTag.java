package org.fao.teldir.tags;

import java.io.PrintStream;

public abstract class AbstractTag {

	protected static String text;

	public String tagClosing() {
		return "<"+tagName()+"/>";
	}

	public String tagOpening() {
		return "<"+tagName()+">";
	}

	public abstract String tagName();

	public void writeTo(PrintStream stream) {
		stream.println(this);
	}
	
	public abstract String toString();
}
