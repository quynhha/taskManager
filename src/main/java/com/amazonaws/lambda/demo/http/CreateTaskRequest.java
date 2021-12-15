package com.amazonaws.lambda.demo.http;

import java.util.UUID;

public class CreateTaskRequest {
	public String name; 
	public UUID id;
	public String projectName;
	
	public CreateTaskRequest(String n , UUID id, String projectname) {
		this.name = n; 
		this.id = id;
		this.projectName = projectname;}
		
	public CreateTaskRequest(String n , String p) {
		this.name = n; 
		this.projectName = p;
	}
	
	public String toString() {
		return "CreateProject(" + name + "," + id + ")";
	}
	
	public CreateTaskRequest() {}
}
