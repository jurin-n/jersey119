package com.herokuapp.jersey119.ex07_1;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

@Path("/ex07_1/customers")
public class CustomerResource {
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomer(@PathParam("id") int id){
		return id==1?"I've got customer.":null;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String create(String newCustomer){
		return newCustomer.equals("")?null:newCustomer;
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("id") int id,String newCustomer){
		
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") int id){
		
	}
}
