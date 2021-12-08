package com.amazonaws.lambda.demo.http;



public class RenameTaskRequest {
	public final String name;
	
	public RenameTaskRequest(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Rename this Project: " + name + "."; 
	}
	
}
