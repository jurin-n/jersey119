package com.herokuapp.jersey119.ex04_1;

import com.herokuapp.jersey119.domain.Customer;

import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URI;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerResourceService extends AbstractCustomerUtil implements CustomerResource {

	private Map<Integer,Customer> customerDB = new ConcurrentHashMap<Integer,Customer>();
	private AtomicInteger idCounter = new AtomicInteger();
	
	public Response createCustomer(InputStream is){
		Customer customer = readCustomer(is);
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(customer.getId(), customer);
		System.out.println("Created customer " + customer.getId());
		return Response.created(
				URI.create("/customers/"+ customer.getId())
						).build();
	}
	
	public void patchCustomer(@PathParam("id") int id, InputStream is){
	}
	
	public StreamingOutput getCustomer(@PathParam("id") int id){
		final Customer customer = customerDB.get(id);
		if(customer==null){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return new StreamingOutput(){
			public void write(OutputStream outputStream)
							throws IOException, WebApplicationException{
				outputCustomer(outputStream,customer);
			}
		};
	}

	public void updateCustomer(
			@PathParam("id") int id,
			InputStream is){
		Customer update = readCustomer(is);
		Customer current = customerDB.get(id);
		if(current == null){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		
		current.setFirstName(update.getFirstName());
		current.setLastName(update.getLastName());
		current.setStreet(update.getStreet());
		current.setState(update.getState());
		current.setZip(update.getZip());
		current.setCountry(update.getCountry());
	}
}
