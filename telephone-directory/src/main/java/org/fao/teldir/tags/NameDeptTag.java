package org.fao.teldir.tags;


public class NameDeptTag extends AbstractTag {

	public static final String NAME = "nameDept";
	
	public NameDeptTag(String staffMemberName) {
		this.text = staffMemberName;
	}

	@Override
	public String toString() {
		return tagOpening()+this.text+tagClosing();
	}

	@Override
	public String tagName() {
		return NAME;
	}
}
