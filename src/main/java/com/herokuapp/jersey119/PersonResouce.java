package com.herokuapp.jersey119;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonResouce {
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam("id") String id){
		Person p = new Person();
		p.setId(id);
		p.setName("test yamada");
		p.setAge(30);
		
		ArrayList<ListData> list = new ArrayList<ListData>();
		list.add(new ListData("aaa","20150501"));
		list.add(new ListData("bob","20150601"));
		list.add(new ListData("ccc","20150701"));
		list.add(new ListData("ddd","20150801"));
		
		p.setList(list);
		return Response
				.status(Response.Status.OK)
				.entity(p)
				.build();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postPerson(Person p){
		String res = "id=" + p.getId() + ",name=" + p.getName();
		List<ListData> list = p.getList();
		String resList ="------------------\n";
		
		if(list!=null){
			for(ListData ld:list){
				resList = resList + "name=" + ld.getName() + ",day=" + ld.getDay() +"\n";
			}
		}
		resList += "-------------------\n";
		return Response
				.status(Response.Status.OK)
				.entity(res+"\n"+resList)
				.build();
	}
}
