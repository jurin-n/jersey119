package com.herokuapp.jersey119.ex07_2;

import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/ex07_2/status")
public class StatusCodeService {
	
	@GET
	@Path("{id}")
	public Response get(){
		return Response.ok("I've got it.").build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(){
		return Response.status(Status.GONE).build();
	}
}
