package com.herokuapp.jersey119.ex06_1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ex06_1/planet")
public class PlanetResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Planet getPlanet(){
		Planet p = new Planet();
		p.setId(1);
		p.setName("Earth");
		p.setRadius(1000.12345);
		return p;
	}
	
}
