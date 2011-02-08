package org.fao.teldir.tags;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class Response {
	
	public static final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	private List<AbstractTag> tags = new ArrayList<AbstractTag>();

	public void add(AbstractTag aTag) {
		System.out.println("Adding "+aTag.toString());
		this.tags.add(aTag);
	}
	
	public void writeTo(PrintStream stream) {
		stream.println(this);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(HEADER);
		
		for (AbstractTag tag : this.tags) {
			builder.append(tag.toString());
		}
		
		
		return builder.toString();
	}

}
