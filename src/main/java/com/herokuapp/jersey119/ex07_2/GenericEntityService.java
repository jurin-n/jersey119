package com.herokuapp.jersey119.ex07_2;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

@Path("/ex07_2/generic_entity")
public class GenericEntityService {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getPlanetList(){
		List<Planet> list = new ArrayList<Planet>();
		list.add(new Planet());
		list.add(new Planet());
		list.add(new Planet());
		
		GenericEntity<List<Planet>> entity = new GenericEntity<List<Planet>>(list){};
		return Response.ok(entity).build();
	}
}
