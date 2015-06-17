package com.herokuapp.jersey119.ex04_1;

import static org.junit.Assert.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class CustomerResourceTest {
	Server server;
	
	@Before
	public void setUp() throws Exception{
		
		System.out.println("Start server.");
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        server = new Server(Integer.valueOf(webPort));
        final WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        root.setParentLoaderPriority(true);

        final String webappDirLocation = "src/main/webapp/";
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);

        server.setHandler(root);

        server.start();
        //server.join();
	}
	
	//@Test
	@Ignore
	public void testPatchMethod() {
		System.out.println("*** testPatchMethod start ***");
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/customers/1");
		wr.method("PATCH");
		System.out.println("*** testPatchMethod end ***");
	}
	
	@Test
	public void testGetMethod() {
		System.out.println("*** testGetMethod start ***");
		Client c = Client.create();
		WebResource wr = c.resource("http://localhost:8080/customers/1");
		wr.method("GET");
		System.out.println("*** testGetMethod end ***");
	}
	
	@After
	public void tearDown() throws Exception{
		server.stop();
		System.out.println("Stop server.");
	}

}
