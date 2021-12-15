package com.amazonaws.lambda.demo.http;

public class AddTeammateRequest {
	public String name; 
	public String project;
	
	public AddTeammateRequest(String n , String p) {
		this.name = n; 
		this.project = p;
	}
	
	public String toString() {
		return "Add Teammate(" + name + ")";
	}
	
	public AddTeammateRequest() {}
}