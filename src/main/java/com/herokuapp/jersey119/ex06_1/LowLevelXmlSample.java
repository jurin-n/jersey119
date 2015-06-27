package com.herokuapp.jersey119.ex06_1;

import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;


@Path("/ex06_1/lowxml")
public class LowLevelXmlSample {
	@Path("1")
	@POST
	public StreamSource get1(StreamSource source){
		return source;
	}
	
	
	@Path("2")
	@POST
	public SAXSource get2(SAXSource source){
		return source;
	}
	
	@Path("3")
	@POST
	public DOMSource get3(DOMSource source){
		return source;
	}

	@Path("4")
	@POST
	public Document get4(Document source){
		return source;
	}
}
