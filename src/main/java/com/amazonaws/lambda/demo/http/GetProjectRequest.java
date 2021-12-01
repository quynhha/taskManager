package com.amazonaws.lambda.demo.http;

import java.util.UUID;

public class GetProjectRequest {
	public String name; 
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	public GetProjectRequest(String n) {
		this.name = n; 
		
	}
	
	public String toString() {
		return "GetProject(" + name + ")";
	}
	
	public GetProjectRequest() {}
}
