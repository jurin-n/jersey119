package com.herokuapp.jersey119;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//The Java class will be hosted at the URI path "/helloworld".
@Path("/helloworld")
public class HelloWorldResource {
	@GET
	@Produces("text/plain")
	public String getClichedMessage(){
		return "Hello World!!";
	}
}
