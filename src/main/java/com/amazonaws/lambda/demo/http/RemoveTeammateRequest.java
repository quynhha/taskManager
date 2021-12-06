package com.amazonaws.lambda.demo.http;

public class RemoveTeammateRequest {
	public String name; 
	public String project;
	
	public String getName() {
		return name;
	}
	
	public String getProject() {
		return this.project;
	}
	
	public void setProject(String project) {
		this.project = project;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public RemoveTeammateRequest(String n , String p) {
		this.name = n; 
		this.project = p;
	}
	
	public String toString() {
		return "Add Teammate(" + name + "," + name + ")";
	}
	
	public RemoveTeammateRequest() {}
}