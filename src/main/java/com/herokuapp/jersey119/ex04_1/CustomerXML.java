package com.herokuapp.jersey119.ex04_1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Customer")
public class CustomerXML {
	@Id
	private int id;	
	private String value;
	
	public CustomerXML(){
		
	}
	public CustomerXML(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
