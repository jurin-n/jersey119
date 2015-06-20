package com.herokuapp.jersey119.ex04_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Ignore;
import org.junit.Test;

public class CustomerResourceTest {
	
	@Test
	public void testPostMethod() throws UnsupportedEncodingException {
		System.out.println("*** testPostMethod start ***");
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost method = new HttpPost("http://localhost:8080/customers");
		method.setHeader("Content-Type", "application/xml");
	    String newCustomer = "<customer>"
	              + "<first-name>Bill</first-name>"
	              + "<last-name>Burke</last-name>"
	              + "<street>256 Clarendon Street</street>"
	              + "<city>Boston</city>"
	              + "<state>MA</state>"
	              + "<zip>02115</zip>"
	              + "<country>USA</country>"
	              + "</customer>";
		method.setEntity(new StringEntity(newCustomer));
		try {
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(201));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		System.out.println("*** testPostMethod end ***");
	}
	
	//@Test
	@Ignore
	public void testPatchMethod() {
		System.out.println("*** testPatchMethod start ***");
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPatch method = new HttpPatch("http://localhost:8080/customers/1");
		try {
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(404));
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
