package com.herokuapp.jersey119.ex04_1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class CustomerResourceTest {

	//@Test
	@Ignore
	public void testPatchMethod() {
		System.out.println("*** testPatchMethod start ***");
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/customers/1");
		wr.method("PATCH");
		System.out.println("*** testPatchMethod end ***");
	}
	
	@Test
	public void testGetMethod() {
		System.out.println("*** testGetMethod start ***");
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/customers/1");
		wr.method("GET");
		System.out.println("*** testGetMethod end ***");
	}

}
