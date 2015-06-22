package com.herokuapp.jersey119.ex04_3;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class SubResource2 implements SubResource {

	@Override
	@GET
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getResource(@PathParam("id") int id) {
		return this.getClass().getName()+".getResource()";
	}
}
