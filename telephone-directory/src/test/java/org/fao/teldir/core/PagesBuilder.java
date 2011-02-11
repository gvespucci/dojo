package org.fao.teldir.core;

public class PagesBuilder {

	public static PagesBuilder somePages() {
		return new PagesBuilder();
	}

	private String numberOfPages;

	public Pages build() {
		Pages pages = new Pages();
		pages.withNumberOfPages(this.numberOfPages);
		return pages;
	}

	public PagesBuilder withNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
		return this;
	}

}
