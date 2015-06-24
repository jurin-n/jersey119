package com.herokuapp.jersey119.ex05_1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Ignore;
import org.junit.Test;

public class CarResourceTest {

	//@Test
	/*
	 * @MatrixParam don't work.
	 * Jersey 1.19 don't support @MatrixParam ?
	 * */
	@Ignore
	public void testMatrixParamの動作を確認する() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			System.out.println("GET http://localhost:8080/ex05_1/matrix/cars/mercedes/e55;color=black/2015");
			HttpGet method = new HttpGet("http://localhost:8080/ex05_1/cars/matrix/mercedes/e55;color=black/2015");
			HttpResponse res = httpClient.execute(method);
			assertThat(
					res.getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			assertThat(
					EntityUtils.toString(res.getEntity(), "UTF-8")
					,is("A black 2015 mercedes e55"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testPathSegmentの動作を確認する() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			System.out.println("GET http://localhost:8080/ex05_1/cars/segment/mercedes/e55;color=black/2015");
			HttpGet method = new HttpGet("http://localhost:8080/ex05_1/cars/segment/mercedes/e55;color=black/2015");
			HttpResponse res = httpClient.execute(method);
			assertThat(
					res.getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			assertThat(
					EntityUtils.toString(res.getEntity(), "UTF-8")
					,is("A black 2015 mercedes e55"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testPathSegmentのListの動作を確認する() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			System.out.println("GET http://localhost:8080/ex05_1/cars/segments/mercedes/e55;color=black/x1;color=red/2015");
			HttpGet method = new HttpGet("http://localhost:8080/ex05_1/cars/segments/mercedes/e55;color=black/x1;color=red/2015");
			HttpResponse res = httpClient.execute(method);
			assertThat(
					res.getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			assertThat(
					EntityUtils.toString(res.getEntity(), "UTF-8")
					,is("A 2015 mercedes e55 black x1 red"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void testUriInfoからPath情報を取得の動作を確認する() {	
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			System.out.println("GET http://localhost:8080/ex05_1/cars/uriinfo/mercedes/e55;color=black/2015");
			HttpGet method = new HttpGet("http://localhost:8080/ex05_1/cars/uriinfo/mercedes/e55;color=black/2015");
			HttpResponse res = httpClient.execute(method);
			assertThat(
					res.getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			assertThat(
					EntityUtils.toString(res.getEntity(), "UTF-8")
					,is("A black 2015 mercedes e55"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
}
