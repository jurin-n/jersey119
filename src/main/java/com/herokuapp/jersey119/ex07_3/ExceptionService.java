package com.herokuapp.jersey119.ex07_3;

import java.util.Locale;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ex07_3")
public class ExceptionService {
	@GET
	@Path("/webappex/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response get(@PathParam("id") int id){
		if(id==2){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		
		String book="I've got books!";
		return Response
				.ok(book)
				.language(Locale.JAPANESE)
				.header("Some-Header", "some value")
				.build();
	}
	
	@GET
	@Path("/exceptionmapper/{service}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getEx(@PathParam("service") String service){
		if(service.equals("exception")){
			throw new ServiceNotFoundException("ServiceNotFoundException at get service");
		}
		
		String book="I've got books!";
		return Response
				.ok(book)
				.language(Locale.JAPANESE)
				.header("Some-Header", "some value")
				.build();
	}
}
