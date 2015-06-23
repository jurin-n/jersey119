package com.herokuapp.jersey119.ex05_1;

import java.util.List;

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
	
	@GET
	@Path("/segment/{make}/{model}/{year}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFromPathSegment(
			@PathParam("make") String make,
			@PathParam("model") PathSegment car,
			@PathParam("year") String year
			){
		
		String carColor = car.getMatrixParameters().getFirst("color");
		return  "A " + carColor + " " + year + " " + make + " " + car.getPath();
	}
	
	@GET
	@Path("/segments/{make}/{model : .+}/{year}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getFromPathSegments(
			@PathParam("make") String make,
			@PathParam("model") List<PathSegment> car,
			@PathParam("year") String year
			){
		String res = "A " + year + " " + make;
		for(PathSegment seg : car){
			res = res + " " + seg.getPath() + " " +  seg.getMatrixParameters().getFirst("color");
		}
		return res;
	}
}
