package com.herokuapp.jersey119.ex07_3;

public class ServiceNotFoundException extends RuntimeException  {
	public ServiceNotFoundException(String s){
		super(s);
	}
}
