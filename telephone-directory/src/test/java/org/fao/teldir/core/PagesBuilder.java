package org.fao.teldir.core;

public class PagesBuilder {

	public static PagesBuilder somePages() {
		return new PagesBuilder();
	}

	private String numberOfPages = "";
	private String currentPage = "";

	public Pages build() {
		Pages pages = new Pages().withNumberOfPages(this.numberOfPages).withCurrentPage(this.currentPage);
		return pages;
	}

	public PagesBuilder withNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
		return this;
	}

	public PagesBuilder withCurrentPage(String currentPage) {
		this.currentPage = currentPage;
		return this;
	}
	
	public static PagesBuilder sixPages() {
		return PagesBuilder.somePages().withNumberOfPages("6");
	}

}
