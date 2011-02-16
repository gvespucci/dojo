package org.fao.teldir.marshall;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MarshallFactoryTest {

	@Test
	public void returnsXmlMarshallerWhenXmlRequested() {
		assertThat(MarshallerFactory.marshaller(Marshaller.XML), is(instanceOf(XmlMarshaller.class)));
	}
	
	@Test
	public void returnsJsonMarshallerWhenJsonRequested() {
		assertThat(MarshallerFactory.marshaller(Marshaller.JSON), is(instanceOf(JsonMarshaller.class)));
	}
	
	@Test
	public void returnsNullMarshallerWhenNullRequested() {
		assertThat(MarshallerFactory.marshaller(null), is(instanceOf(NullMarshaller.class)));
	}
	
	@Test
	public void returnsNullMarshallerWhenEmptyRequested() {
		assertThat(MarshallerFactory.marshaller(""), is(instanceOf(NullMarshaller.class)));
	}

}
