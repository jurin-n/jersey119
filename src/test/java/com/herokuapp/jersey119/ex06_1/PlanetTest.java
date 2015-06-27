package com.herokuapp.jersey119.ex06_1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class PlanetTest {

	@Test
	public void testPlanetGet() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet method = new HttpGet("http://localhost:8080/ex06_1/planet");
		method.setHeader("Content-Type", "application/xml");
		try {
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(HttpURLConnection.HTTP_OK));
			System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testPlanetPost() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost method = new HttpPost("http://localhost:8080/ex06_1/planet");
		method.setHeader("Content-Type", "application/xml");
	    String newCustomer = 
	    			"<planet id=\"10\">"
	              + "<name>earth</name>"
	              + "<radius>10.12345</radius>"
	              + "</planet>";
		try {
			StringEntity se = new StringEntity(newCustomer);
			se.setContentType("application/xml");
			method.setEntity(se);
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(HttpURLConnection.HTTP_OK));
			System.out.println("** testPlanetPost out **");
			System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
