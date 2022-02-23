package com.amazonaws.lambda.demo.http;

public class GetProjectRequest {
	public String name; 
	
	
	public GetProjectRequest(String n) {
		this.name = n; 
		
	}
	
	public String toString() {
		return "GetProject(" + name + ")";
	}
	
	public GetProjectRequest() {}
}
