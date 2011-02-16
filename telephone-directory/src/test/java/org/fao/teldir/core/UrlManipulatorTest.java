package org.fao.teldir.core;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UrlManipulatorTest {
	
	private String urlToManipulate = "/yabba-dabba-doo?searchType=teldir&respg=3&pg=teldir&search_string=561";
	private UrlManipulator manipulator;
	
	@Before
	public void setUp() {
		manipulator = new UrlManipulator(this.urlToManipulate);
	}

	@Ignore @Test
	public void 
	putAtLastReturnsTheSameUrlWhenParameterIsEmpty() {
		String actualUrl = manipulator.putAsLast("");
		assertThat(actualUrl, is(equalTo(actualUrl)));
	}
	
	@Ignore @Test
	public void 
	putAtLastReturnsTheSameUrlWhenParameterIsNull() {
		String actualUrl = manipulator.putAsLast(null);
		assertThat(actualUrl, is(equalTo(actualUrl)));
	}
	
	@Test
	public void
	manipulatedUrlEndsWithRequestedParameter() {
		assertThat(manipulator.putAsLast("last-param"), endsWith("&last-param="));
		assertThat(manipulator.putAsLast("EXOGEN"), endsWith("&EXOGEN="));
		assertThat(manipulator.putAsLast("mr-magoo"), endsWith("&mr-magoo="));
		assertThat(manipulator.putAsLast("godzilla"), endsWith("&godzilla="));
	}

}
