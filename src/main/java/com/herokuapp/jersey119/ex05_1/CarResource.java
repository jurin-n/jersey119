package com.herokuapp.jersey119.ex05_1;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.MatrixParam;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;


@Path("/ex05_1/cars")
public class CarResource {
	public static enum Color{
		red,
		white,
		blue,
		black
	}
	
	@GET
	@Path("/matrix/{make}/{model}/{year}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFromMatrixParam(
			@PathParam("make") String make,
			@PathParam("model") PathSegment car,
			@MatrixParam("color") String color,
			@PathParam("year") String year
			){
		return "A " + color + " " + year + " " + make + " " + car.getPath();
	}
	
}
