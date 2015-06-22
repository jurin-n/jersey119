package com.herokuapp.jersey119.ex04_3;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/ex04_3")
public class Resource {
	@Path("{subresource}")
	public SubResource getResouce(@PathParam("subresource") String subresource){
		System.out.println("subresource-->" + subresource);
		if(subresource.equals("subresource1")){
			System.out.println("return SubResource1.");
			return new SubResource1();
		}
			
		if(subresource.equals("subresource2")){
			System.out.println("return SubResource2.");
			return new SubResource2();
		}
		
		System.out.println("No Resource.");
		return null;
	}
}
