package org.fao.teldir.core;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("pages")
@ToString
@EqualsAndHashCode
public class Pages {
	@XStreamAsAttribute
	@XStreamAlias("num")
	private String numberOfPages = "";
	
	@XStreamAsAttribute
	@XStreamAlias("curr")
	private String currentPage = "";
	
	@XStreamAsAttribute
	@XStreamAlias("prev")
	private String previousPage = "";
	
	@XStreamAsAttribute
	@XStreamAlias("next")
	private String nextPage = "";
	
	@XStreamAlias("url")
	@XStreamAsAttribute
	private String baseUrl = "";

	public Pages withNumberOfPages(String numberOfPages) {
		if( isThereAtLeastOnePage(numberOfPages)) {
			this.numberOfPages = numberOfPages;
		}
		return this;
	}

	private boolean isThereAtLeastOnePage(String numberOfPages) {
		return ! "0".equals(numberOfPages);
	}
	

	public Pages withCurrentPage(String currentPage) {
		this.currentPage = currentPage;
		return this;
	}
	
	public Pages withPreviousPage(String previousPage) {
		this.previousPage = previousPage;
		return this;
	}

	public Pages withNextPage(String nextPage) {
		this.nextPage = nextPage;
		return this;
	}
	
	public Pages withBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
		return this;
	}
	
	public String current() {
		return this.currentPage;
	}
	
	public String previous() {
		return this.previousPage;
	}
	
	public String next() {
		return this.nextPage;
	}
	
	public String howMany() {
		return this.numberOfPages;
	}
	
	public String url() {
		return this.baseUrl;
	}
	
	
}
