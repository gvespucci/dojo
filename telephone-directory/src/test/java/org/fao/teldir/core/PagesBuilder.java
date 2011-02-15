package org.fao.teldir.core;

public class PagesBuilder {

	public static PagesBuilder somePages() {
		return new PagesBuilder();
	}

	private String numberOfPages = "";
	private String currentPage = "";
	private String previousPage = "";
	private String nextPage = "";

	public Pages build() {
		Pages pages = new Pages()
			.withNumberOfPages(this.numberOfPages)
			.withCurrentPage(this.currentPage)
			.withPreviousPage(this.previousPage)
			.withNextPage(this.nextPage);
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

	public PagesBuilder withPreviousPage(String previousPage) {
		this.previousPage  = previousPage;
		return this;
	}

	public PagesBuilder withNextPage(String nextPage) {
		this.nextPage  = nextPage;
		return this;
	}

}
