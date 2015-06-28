package com.herokuapp.jersey119.ex06_2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

@Provider
@Consumes(MediaType.APPLICATION_XML)
public class JAXBUnmarshaller implements MessageBodyReader<Planet> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType) {
		return type.isAnnotationPresent(XmlRootElement.class);
	}

	@Override
	public Planet readFrom(Class<Planet> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, String> HttpHeaders,
			InputStream entityStream) throws IOException, WebApplicationException {
		try{
			JAXBContext ctx = JAXBContext.newInstance(type);
			return (Planet)ctx.createUnmarshaller().unmarshal(entityStream);
		}catch(JAXBException ex){
			throw new RuntimeException(ex);
		}
	}

}
