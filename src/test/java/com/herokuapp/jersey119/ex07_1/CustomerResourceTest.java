package com.herokuapp.jersey119.ex07_1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class CustomerResourceTest {

	@Test
	public void testHTTP_GET_methodテスト() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet method=null;
			method = new HttpGet("http://localhost:8080/ex07_1/customers/1");
			method.setHeader("Accept", "application/json");	
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
						,is(HttpURLConnection.HTTP_OK));
			
			method = new HttpGet("http://localhost:8080/ex07_1/customersXXX/1");
			method.setHeader("Accept", "application/json");	
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
						,is(HttpURLConnection.HTTP_NOT_FOUND));
			
			method = new HttpGet("http://localhost:8080/ex07_1/customers");
			method.setHeader("Accept", "application/json");	
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
						,is(HttpURLConnection.HTTP_BAD_METHOD));

			method = new HttpGet("http://localhost:8080/ex07_1/customers/2");
			method.setHeader("Accept", "application/json");	
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
						,is(HttpURLConnection.HTTP_NO_CONTENT));

		
			method = new HttpGet("http://localhost:8080/ex07_1/customers/1");
			method.setHeader("Accept", "text/html");
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
						,is(HttpURLConnection.HTTP_NOT_ACCEPTABLE));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testHTTP_POST_methodテスト() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost method = null;
			StringEntity se =null;
			
			method = new HttpPost("http://localhost:8080/ex07_1/customers");
			method.setHeader("Accept", "application/json");
			se = new StringEntity("{id=\"1\",name=\"test\"}");
			se.setContentType("application/json");
			method.setEntity(se);
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));


			method = new HttpPost("http://localhost:8080/ex07_1/customers");
			method.setHeader("Accept", "application/json");
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_NO_CONTENT));
			
			method = new HttpPost("http://localhost:8080/ex07_1/customers");
			method.setHeader("Accept", "application/xml");
			se = new StringEntity("<customer><id>1</id><name>test</name></customer>");
			se.setContentType("application/json");
			method.setEntity(se);
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_NOT_ACCEPTABLE));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testHTTP_PUT_methodテスト() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPut method = null;
			StringEntity se =null;

			method = new HttpPut("http://localhost:8080/ex07_1/customers/1");
			method.setHeader("Accept", "application/json");
			se = new StringEntity("{id=\"1\",name=\"test\"}");
			se.setContentType("application/json");
			method.setEntity(se);
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_NO_CONTENT));

			
			method = new HttpPut("http://localhost:8080/ex07_1/customersXXX/1");
			method.setHeader("Accept", "application/json");
			se = new StringEntity("{id=\"1\",name=\"test\"}");
			se.setContentType("application/json");
			method.setEntity(se);
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_NOT_FOUND));

		
			method = new HttpPut("http://localhost:8080/ex07_1/customers/");
			method.setHeader("Accept", "application/json");
			se = new StringEntity("{id=\"1\",name=\"test\"}");
			se.setContentType("application/json");
			method.setEntity(se);
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_BAD_METHOD));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testHTTP_DELETE_methodテスト() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpDelete method = null;

			method = new HttpDelete("http://localhost:8080/ex07_1/customers/1");
			method.setHeader("Accept", "application/json");
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_NO_CONTENT));

			method = new HttpDelete("http://localhost:8080/ex07_1/customersXX/1");
			method.setHeader("Accept", "application/json");
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_NOT_FOUND));
		
			
			method = new HttpDelete("http://localhost:8080/ex07_1/customers");
			method.setHeader("Accept", "application/json");
			assertThat(httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_BAD_METHOD));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
