package com.herokuapp.jersey119.ex05_2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class CustomerResourceTest {

	@Test
	public void testHttpHeader取得の動作を確認する() {
		try {
			
			
			System.out.println("GET http://localhost:8080/ex05_2/customer/yamaha/a5/2015");
			HttpGet method = new HttpGet("http://localhost:8080/ex05_2/customer/yamaha/a5/2015");
			// headers
			List<Header> headers = new ArrayList<Header>();
			headers.add(new BasicHeader("Accept-Charset","utf-8"));
			headers.add(new BasicHeader("Accept-Language","ja, en;q=0.8"));
			headers.add(new BasicHeader("Auth","xxx"));
			headers.add(new BasicHeader("AAAAA","bbbb"));
			HttpClient httpClient = HttpClientBuilder
										.create()
										.setDefaultHeaders(headers)
										.build();
			
			HttpResponse res = httpClient.execute(method);
			assertThat(
					res.getStatusLine().getStatusCode()
					,is(HttpURLConnection.HTTP_OK));
			/*
			assertThat(
					EntityUtils.toString(res.getEntity(), "UTF-8")
					,is("**** Headers  ****Accept-Charset=[utf-8]¥nAAAAA=[bbbb]¥nAuth=[xxx]¥nConnection=[keep-alive]¥nUser-Agent=[Apache-HttpClient/4.5 (Java/1.8.0_20)]¥nHost=[localhost:8080]¥nAccept-Language=[ja, en;q=0.8]¥nAccept-Encoding=[gzip,deflate]¥n¥n**** Uri  ****¥nmake=yamaha¥nmodel=a5¥nyear=2015"));
			*/
			System.out.println("---------------  Response  ---------------");
			System.out.println(EntityUtils.toString(res.getEntity(), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}

}
