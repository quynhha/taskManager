package com.amazonaws.lambda.demo.http;

public class RemoveTeammateRequest {
	public String name; 
	public String project;
	
	public RemoveTeammateRequest(String n , String p) {
		this.name = n; 
		this.project = p;
	}
	
	public String toString() {
		return "Add Teammate(" + name + "," + name + ")";
	}
	
	public RemoveTeammateRequest() {}
}