package com.amazonaws.lambda.demo.http;

import java.util.UUID;

public class GetTaskRequest {
	public String name; 
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	public GetTaskRequest(String n) {
		this.name = n; 
		
	}
	
	public String toString() {
		return "GetTask(" + name + ")";
	}
	
	public GetTaskRequest() {}
}
