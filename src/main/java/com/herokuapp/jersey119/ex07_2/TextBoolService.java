package com.herokuapp.jersey119.ex07_2;

import java.util.Locale;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ex07_2/textbook")
public class TextBoolService {
	
	@GET
	@Path("/restfuljava")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getBook(){
		String book="I've got books!";
		return Response
				.ok(book)
				.language(Locale.JAPANESE)
				.header("Some-Header", "some value")
				.build();
	}
}
