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
import org.junit.Test;

public class CustomerResourceTest {

	@Test
	public void testQueryParamからパラメータ情報取得の動作を確認する() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			System.out.println("GET http://localhost:8080/ex05_1/customer/query?start=101&size=100");
			HttpGet method = new HttpGet("http://localhost:8080/ex05_1/customer/query?start=101&size=100");
			HttpResponse res = httpClient.execute(method);
			assertThat(
					res.getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			assertThat(
					EntityUtils.toString(res.getEntity(), "UTF-8")
					,is("start=101, size=100"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test
	public void testUriInfoからパラメータ情報取得の動作を確認する() {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			
			System.out.println("GET http://localhost:8080/ex05_1/customer/uriinfo/query?start=101&size=100");
			HttpGet method = new HttpGet("http://localhost:8080/ex05_1/customer/uriinfo/query?start=101&size=100");
			HttpResponse res = httpClient.execute(method);
			assertThat(
					res.getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			assertThat(
					EntityUtils.toString(res.getEntity(), "UTF-8")
					,is("start=101, size=100"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}	
	}

}
