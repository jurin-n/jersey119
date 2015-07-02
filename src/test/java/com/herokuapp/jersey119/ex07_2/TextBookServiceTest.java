package com.herokuapp.jersey119.ex07_2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TextBookServiceTest {

	@Test
	public void testGetBook_Method() {
		try{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet method=null;
			HttpResponse response = null;
			method = new HttpGet("http://localhost:8080/ex07_2/textbook/restfuljava");
			method.setHeader("Accept", "text/plain");	
			response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode()
						,is(HttpURLConnection.HTTP_OK));
			System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
			
			method = new HttpGet("http://localhost:8080/ex07_2/textbook/restfuljava");
			method.setHeader("Accept", "application/xml");	
			response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode()
						,is(HttpURLConnection.HTTP_NOT_ACCEPTABLE));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
