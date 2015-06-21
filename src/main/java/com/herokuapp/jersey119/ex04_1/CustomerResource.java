package com.herokuapp.jersey119.ex04_1;

import java.io.InputStream;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import com.herokuapp.jersey119.annotations.PATCH;

public interface CustomerResource {

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	//public Response createCustomer(InputStream is);
	public Response createCustomer(String s);
	
	/*
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String getCustomer(@PathParam("id") int id);
	*/
	
	/*
	@PATCH
	@Consumes(MediaType.APPLICATION_XML)
	//public void patchCustomer(@PathParam("id") int id, InputStream is);
	public void patchCustomer(@PathParam("id") int id, String s);
	*/
	
	/*
	public String getCustomer(@PathParam("id") int id);
	*/
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_XML)
	//public void updateCustomer(@PathParam("id") int id,InputStream is);
	public void updateCustomer(@PathParam("id") int id,String s);
}
