package com.herokuapp.jersey119.ex07_3;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceNotFoundExceptionMapper implements ExceptionMapper<ServiceNotFoundException> {
	public Response toResponse(ServiceNotFoundException e){
		return Response
				.status(Response.Status.NOT_FOUND)
				.entity("entity from ServiceNotFoundExceptionMapper.")
				.build();
	}
}
