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
	public void returnsXmlMarshallerWhenXmlIgnoreCaseRequested() {
		assertThat(MarshallerFactory.marshaller(Marshaller.XML.toUpperCase()), is(instanceOf(XmlMarshaller.class)));
		assertThat(MarshallerFactory.marshaller(Marshaller.XML.toLowerCase()), is(instanceOf(XmlMarshaller.class)));
	}
	
	@Test
	public void returnsJsonMarshallerWhenJsonRequested() {
		assertThat(MarshallerFactory.marshaller(Marshaller.JSON), is(instanceOf(JsonMarshaller.class)));
	}
	
	@Test
	public void returnsJsonMarshallerWhenJsonIgnoreCaseRequested() {
		assertThat(MarshallerFactory.marshaller(Marshaller.JSON.toUpperCase()), is(instanceOf(JsonMarshaller.class)));
		assertThat(MarshallerFactory.marshaller(Marshaller.JSON.toLowerCase()), is(instanceOf(JsonMarshaller.class)));
	}
	
	@Test
	public void returnsXmlMarshallerWhenNullRequested() {
		assertThat(MarshallerFactory.marshaller(null), is(instanceOf(XmlMarshaller.class)));
	}
	
	@Test
	public void returnsXmlMarshallerWhenEmptyRequested() {
		assertThat(MarshallerFactory.marshaller(""), is(instanceOf(XmlMarshaller.class)));
	}
	
	@Test
	public void returnsNullMarshallerWhenRequested() {
		assertThat(MarshallerFactory.nullMarshaller(), is(instanceOf(NullMarshaller.class)));
	}

}
