package com.herokuapp.jersey119.ex07_2;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/ex07_2/cookies")
public class CookieService {

	@GET
	public Response get(){
		/*
		NewCookie cookie = new NewCookie(
				"key",
		         "aaa",
		         "/ex07_2/cookies",
		         "localhost",
		         1,
		         "test",
		         1000,
		         new Date(),
		         false,
		         true);
		*/
		NewCookie cookie = new NewCookie(
				"key",
		         "aaa");	
		return Response
				.ok("ok",MediaType.TEXT_PLAIN)
				.cookie(cookie)
				.build();
	}
}
