package org.fao.teldir.core;

import lombok.ToString;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@ToString
@XStreamAlias("pages")
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
	
	@XStreamAlias("base-url")
	@XStreamAsAttribute
	private String baseUrl = "";

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseUrl == null) ? 0 : baseUrl.hashCode());
		result = prime * result
				+ ((currentPage == null) ? 0 : currentPage.hashCode());
		result = prime * result
				+ ((nextPage == null) ? 0 : nextPage.hashCode());
		result = prime * result
				+ ((numberOfPages == null) ? 0 : numberOfPages.hashCode());
		result = prime * result
				+ ((previousPage == null) ? 0 : previousPage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pages other = (Pages) obj;
		if (baseUrl == null) {
			if (other.baseUrl != null)
				return false;
		} else if (!baseUrl.equals(other.baseUrl))
			return false;
		if (currentPage == null) {
			if (other.currentPage != null)
				return false;
		} else if (!currentPage.equals(other.currentPage))
			return false;
		if (nextPage == null) {
			if (other.nextPage != null)
				return false;
		} else if (!nextPage.equals(other.nextPage))
			return false;
		if (numberOfPages == null) {
			if (other.numberOfPages != null)
				return false;
		} else if (!numberOfPages.equals(other.numberOfPages))
			return false;
		if (previousPage == null) {
			if (other.previousPage != null)
				return false;
		} else if (!previousPage.equals(other.previousPage))
			return false;
		return true;
	}

	public void withNumberOfPages(String numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	
}
