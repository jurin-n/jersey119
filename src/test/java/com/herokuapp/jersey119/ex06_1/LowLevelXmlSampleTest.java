package com.herokuapp.jersey119.ex06_1;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.net.HttpURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class LowLevelXmlSampleTest {

	@Test
	public void testStreamSourceClass() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost method = new HttpPost("http://localhost:8080/ex06_1/lowxml/1");
		method.setHeader("Content-Type", "application/xml");
	    String newCustomer = "<customer>"
	              + "<first-name>test</first-name>"
	              + "<last-name>taro</last-name>"
	              + "<street>Roppongi Street</street>"
	              + "<city>Minato Ku</city>"
	              + "<state>Tokyo</state>"
	              + "<zip>123-456</zip>"
	              + "<country>Japan</country>"
	              + "</customer>";
		try {
			method.setEntity(new StringEntity(newCustomer));
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(HttpURLConnection.HTTP_OK));
			System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testSAXSourceClass() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost method = new HttpPost("http://localhost:8080/ex06_1/lowxml/2");
		method.setHeader("Content-Type", "application/xml");
	    String newCustomer = "<customer>"
	              + "<first-name>test</first-name>"
	              + "<last-name>taro</last-name>"
	              + "<street>Roppongi Street</street>"
	              + "<city>Minato Ku</city>"
	              + "<state>Tokyo</state>"
	              + "<zip>123-456</zip>"
	              + "<country>Japan</country>"
	              + "</customer>";
		try {
			method.setEntity(new StringEntity(newCustomer));
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(HttpURLConnection.HTTP_OK));
			System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDOMSourceClass() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost method = new HttpPost("http://localhost:8080/ex06_1/lowxml/3");
		method.setHeader("Content-Type", "application/xml");
	    String newCustomer = "<customer>"
	              + "<first-name>test</first-name>"
	              + "<last-name>taro</last-name>"
	              + "<street>Roppongi Street</street>"
	              + "<city>Minato Ku</city>"
	              + "<state>Tokyo</state>"
	              + "<zip>123-456</zip>"
	              + "<country>Japan</country>"
	              + "</customer>";
		try {
			method.setEntity(new StringEntity(newCustomer));
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(HttpURLConnection.HTTP_OK));
			System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testDocumentClass() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost method = new HttpPost("http://localhost:8080/ex06_1/lowxml/4");
		method.setHeader("Content-Type", "application/xml");
	    String newCustomer = "<customer>"
	              + "<first-name>test</first-name>"
	              + "<last-name>taro</last-name>"
	              + "<street>Roppongi Street</street>"
	              + "<city>Minato Ku</city>"
	              + "<state>Tokyo</state>"
	              + "<zip>123-456</zip>"
	              + "<country>Japan</country>"
	              + "</customer>";
		try {
			method.setEntity(new StringEntity(newCustomer));
			HttpResponse response = httpClient.execute(method);
			assertThat(response.getStatusLine().getStatusCode(),is(HttpURLConnection.HTTP_OK));
			System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
