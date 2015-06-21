package com.herokuapp.jersey119.ex04_2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class CustomerResourceTest {
	

	@Test
	public void testPathは数値のみであること() {
		System.out.println("*** Pathは数値のみであること start ***");
		
		try {
			System.out.println("Pathが数値の場合");
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet method = new HttpGet("http://localhost:8080/ex04_2/customers/1");
			assertThat(
					 httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			
			System.out.println("Pathが数値以外の場合");
			method = new HttpGet("http://localhost:8080/ex04_2/customers/aaa");
			assertThat(
					 httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_NOT_FOUND));
		
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		System.out.println("*** Pathは数値のみであること end ***");
	}
	
	@Test
	public void testPathはfirstNameとハイフンとlastNameであること() {
		System.out.println("*** PathはfirstNameとハイフンとlastNameであること start ***");
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet method = new HttpGet("http://localhost:8080/ex04_2/customers2/test-taro");
			assertThat(
					 httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			
			method = new HttpGet("http://localhost:8080/ex04_2/customers2/test-taro-xxx");
			assertThat(
					 httpClient.execute(method).getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_NOT_FOUND));
		
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		System.out.println("*** PathはfirstNameとハイフンとlastNameであること end ***");
	}
}
