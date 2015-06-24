package com.herokuapp.jersey119.ex05_1;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/ex05_1/customer")
public class CustomerResource {
	@GET
	@Path("/query")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFromQuery(
			final @QueryParam("start") int start,
			final @QueryParam("size") @DefaultValue("2") int size
			){
		
		return "start=" + start + ", size=" + size;
	}
	
	@GET
	@Path("/uriinfo/query")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFromQueryInUriInfo(@Context UriInfo info){
		int start = 0;
		int size = 2;
		
		if(info.getQueryParameters().containsKey("start")){
			start= Integer.valueOf(
					info.getQueryParameters().getFirst("start")
					);
		}
		
		if(info.getQueryParameters().containsKey("size")){
			size= Integer.valueOf(
					info.getQueryParameters().getFirst("size")
					);
		}
		return getFromQuery(start,size);
	}
}
