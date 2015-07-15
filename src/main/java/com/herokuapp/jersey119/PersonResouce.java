package com.herokuapp.jersey119;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonResouce {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson(){
		Person p = new Person();
		p.setName("test yamada");
		p.setAge(30);
		
		ArrayList<ListData> list = new ArrayList<ListData>();
		list.add(new ListData("aaa","20150501"));
		list.add(new ListData("bob","20150601"));
		list.add(new ListData("ccc","20150701"));
		list.add(new ListData("ddd","20150801"));
		
		p.setList(list);
		return p;
	}
}
