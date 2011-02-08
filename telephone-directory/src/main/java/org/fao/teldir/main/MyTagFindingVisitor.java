package org.fao.teldir.main;

import org.htmlparser.Tag;
import org.htmlparser.tags.TableTag;
import org.htmlparser.visitors.TagFindingVisitor;

public class MyTagFindingVisitor extends TagFindingVisitor {

	public MyTagFindingVisitor(String[] tagsToBeFound) {
		super(tagsToBeFound);
	}
	
	@Override
	public void visitTag(Tag tag) {
		super.visitTag(tag);
		
		if(tag instanceof TableTag) {
			TableTag tableTag = (TableTag)tag;
			
			String attribute = tableTag.getAttribute("class");
			
			System.out.println(tableTag.getText());
			System.out.println(attribute);
		}
	}

}
