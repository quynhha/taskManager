package com.amazonaws.lambda.demo.http;

public class DeleteProjectRequest {
	public final String name;
	
	public DeleteProjectRequest(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Remove this Project: " + name + "."; 
	}
	
}
