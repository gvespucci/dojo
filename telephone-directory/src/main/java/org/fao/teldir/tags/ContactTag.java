package org.fao.teldir.tags;


public class ContactTag extends AbstractTag {

	private NameDeptTag nameDept;

	@Override
	public String tagName() {
		return "contact";
	}

	public ContactTag withNameDept(NameDeptTag nameDeptTag) {
		this.nameDept = nameDeptTag;
		return this;
	}

	@Override
	public String toString() {
		return tagOpening()+"\n\t"+this.nameDept.toString()+"\n"+tagClosing();
	}

}
