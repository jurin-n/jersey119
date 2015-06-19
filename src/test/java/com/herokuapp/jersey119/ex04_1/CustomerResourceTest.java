package com.herokuapp.jersey119.ex04_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class CustomerResourceTest {	
	@Test
	public void testPatchMethod() {
		System.out.println("*** testPatchMethod start ***");
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPatch method = new HttpPatch("http://localhost:8080/customers/1");
		try {
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(204));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		System.out.println("*** testPatchMethod end ***");
	}
	
	@Test
	public void testGetMethod() {
		System.out.println("*** testGetMethod start ***");
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet method = new HttpGet("http://localhost:8080/customers/1");
		try {
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(200));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		System.out.println("*** testGetMethod end ***");
	}
}
