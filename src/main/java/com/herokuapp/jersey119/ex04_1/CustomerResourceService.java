package com.herokuapp.jersey119.ex04_1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.herokuapp.jersey119.annotations.PATCH;

import java.net.URI;
import java.util.List;

@Path("/ex04_1/customers")
public class CustomerResourceService implements CustomerResource {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mydata");
	
	@Override
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
		
		System.out.println("getCustomer end");
		return cx.getValue();
	}

	@Override
	public void updateCustomer(
			@PathParam("id") int id,
			String s){
		System.out.println("updateCustomer start");
		
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("FROM CustomerXML where id=:id").setParameter("id", id);		
		List<CustomerXML> list = (List<CustomerXML>)q.getResultList();
		if(list.size()==0){
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		CustomerXML cx = (CustomerXML)list.get(0);
		cx.setValue(s);
		
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(cx);
		transaction.commit();
		manager.close();
		
		System.out.println("updateCustomer end");
	}

	@Path("{id}")
	@PATCH
	@Consumes(MediaType.APPLICATION_XML)
	public void patchCustomer(
			@PathParam("id") int id,
			String s){
		System.out.println("patchCustomer start");
		
		updateCustomer(id,s);
		
		System.out.println("patchCustomer end");
	}
}
