package com.herokuapp.jersey119.ex05_2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/ex05_2/customer")
public class CustomerResource {
	@GET
	@Path("/{make}/{model}/{year}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getHeaders(
			 @Context UriInfo info
			,@Context HttpHeaders headers
			,String body
			){
		
		
		MultivaluedMap<String,String> mm = headers.getRequestHeaders();
		String output="";
		output = "**** Headers  ****";
		for(String key:mm.keySet()){
			output = output + key + "=" + mm.get(key) +"¥n";
		}
		
		output += "¥n**** Uri  ****¥n";
		String make = info.getPathParameters().getFirst("make");
		String model = info.getPathParameters().getFirst("model");
		String year = info.getPathParameters().getFirst("year");
		output = output + "make=" + make + "¥n" +"model=" + model + "¥n" + "year=" + year; 
		return Response.ok(output).build();
	}
}
