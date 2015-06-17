package com.herokuapp.jersey119.ex04_1;

import com.herokuapp.jersey119.annotations.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import java.io.InputStream;

@Path("/customers")
public class CustomerResource {

	@PATCH
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_XML)
	public void patchCustomer(@PathParam("id") int id, InputStream is){
	}
	
	@GET
	@Path("{id}")
	public String getCustomer(@PathParam("id") int id){
		return "getCustomer id=" + id;
	}
}
