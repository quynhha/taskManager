package com.amazonaws.lambda.demo.http;

import java.util.UUID;

public class CreateProjectRequest {
	public String name; 
	public UUID id;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public UUID getID() {
		return id;
	}
	public void setID(UUID id) {
		this.id = id; 
	}
	
	public CreateProjectRequest(String n , UUID id) {
		this.name = n; 
		this.id = id;
	}
	
	public String toString() {
		return "CreateProject(" + name + "," + id + ")";
	}
	
	public CreateProjectRequest() {}
}
