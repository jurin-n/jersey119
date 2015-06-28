package com.herokuapp.jersey119.ex06_2;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Context;

import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import javax.ws.rs.ext.ContextResolver;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.Marshaller;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class JAXBMarshaller implements MessageBodyWriter<Planet> {
	@Context
	protected Providers providers;
	
	@Override
	public boolean isWriteable(Class<?> type, Type genericType,
			Annotation annotations[], MediaType mediaType){
		return type.isAnnotationPresent(XmlRootElement.class);
	}
	
	@Override
	public long getSize(
			 Planet obj
			,Class<?> type
			,Type genericType
			,Annotation annotations[]
			,MediaType mediaType){
		return -1L;
	}
	
	@Override
	public void writeTo(Planet target, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream outputStream)
			throws IOException, WebApplicationException {
		try{
			JAXBContext ctx = null;
			ContextResolver<JAXBContext> resolver
				= providers.getContextResolver(JAXBContext.class, mediaType);
			if(resolver != null){
				ctx = resolver.getContext(type);
			}
			if(ctx==null){
				ctx = JAXBContext.newInstance(type);
			}
			Marshaller m = ctx.createMarshaller();
			boolean pretty = false;
			for(Annotation ann : annotations){
				if(ann.annotationType().equals(Pretty.class)){
					pretty = true;
					break;
				}
			}

			if(pretty){
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
			}
			
			m.marshal(target, outputStream);
		}catch(JAXBException ex){
			throw new RuntimeException(ex);
		}
		
	}
}
