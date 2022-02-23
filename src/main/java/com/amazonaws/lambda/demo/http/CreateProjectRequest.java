package com.amazonaws.lambda.demo.http;

import java.util.UUID;

public class CreateProjectRequest {
	public String name; 
	public UUID id;
	
	public CreateProjectRequest(String n , UUID id) {
		this.name = n; 
		this.id = id;
	}
	
	/*
	public String toString() {
		//return "CreateProject(" + name + "," + id + ")";
	}*/
	
	public CreateProjectRequest() {}
}
