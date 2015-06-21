package com.herokuapp.jersey119.ex04_2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ex04_2")
public class CustomersResourceService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCustomer(){
		return "/ex04_2/customers test";
	}
	
	@GET
	@Path("/customers/{id:[0-9]+}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCustomer(@PathParam("id") int id){
		return "I got Customer!";
	}
	
	
	@GET
	@Path("/customers2/{first:[a-zA-Z]+}-{last:[a-zA-Z]+}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCustomerFirstAndLastName(
			 @PathParam("first") String first
			,@PathParam("last") String last
			){
		return "I got Customer2! formated first and last name.";
	}
}
