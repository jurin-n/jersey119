package com.herokuapp.jersey119.ex04_1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.InputStream;
import java.net.URI;
import java.util.List;

@Path("/customers")
public class CustomerResourceService extends AbstractCustomerUtil implements CustomerResource {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mydata");
	
	public Response createCustomer(String s) {
		System.out.println("createCustomer.s=" + s);
		
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("FROM CustomerXML");
		int size = q.getResultList().size();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		int id = (size==0 ? 1:size+1);
		manager.persist(new CustomerXML(id,s));
		transaction.commit();
		manager.close();
		
		return Response.created(
				URI.create("/customers/"+ id)
						).build();
	}
	
	public void patchCustomer(@PathParam("id") int id, InputStream is){
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String getCustomer(@PathParam("id") int id){
		System.out.println("getCustomer start");
		
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("FROM CustomerXML where id=:id").setParameter("id", id);		
		List<CustomerXML> list = (List<CustomerXML>)q.getResultList();
		if(list.size()==0){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		CustomerXML cx = (CustomerXML)list.get(0);
		return cx.getValue();
	}

	public void updateCustomer(
			@PathParam("id") int id,
			InputStream is){
/*
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
*/
	}
}
