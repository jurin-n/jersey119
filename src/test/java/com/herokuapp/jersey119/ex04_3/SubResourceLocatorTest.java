package com.herokuapp.jersey119.ex04_3;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class SubResourceLocatorTest {
	
/*
 * http://localhost:8080/ex04_3/resource1/1
 * http://localhost:8080/ex04_3/resource2/1
 * 
 * */
	@Test
	public void testHttpGETメソッドでSubresourceを取得() {		
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			System.out.println("GET http://localhost:8080/ex04_3/subresource1/1");
			HttpGet method = new HttpGet("http://localhost:8080/ex04_3/subresource1/1");
			HttpResponse res = httpClient.execute(method);
			assertThat(
					res.getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			assertThat(
					EntityUtils.toString(res.getEntity(), "UTF-8")
					,is("com.herokuapp.jersey119.ex04_3.SubResource1.getResource()"));
			
			System.out.println("GET http://localhost:8080/ex04_3/subresource2/1");
			method = new HttpGet("http://localhost:8080/ex04_3/subresource2/1");
			res = httpClient.execute(method);
			assertThat(
					res.getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			assertThat(
					EntityUtils.toString(res.getEntity(), "UTF-8")
					,is("com.herokuapp.jersey119.ex04_3.SubResource2.getResource()"));
		
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
}
