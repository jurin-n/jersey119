package com.herokuapp.jersey119.ex07_2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class StatusCodeServiceTest {

	@Test
	public void testStatus列挙型をテストする() {
		try{
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpDelete method=null;
			HttpResponse response = null;
			method = new HttpDelete("http://localhost:8080/ex07_2/status/1");
			//method.setHeader("Accept", "text/plain");	
			response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode()
						,is(HttpURLConnection.HTTP_GONE));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
