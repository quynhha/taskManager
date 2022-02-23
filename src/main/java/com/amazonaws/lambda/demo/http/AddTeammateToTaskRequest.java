package com.amazonaws.lambda.demo.http;

public class AddTeammateToTaskRequest {
	public String name; 
	public String task;
	public String project;

	public AddTeammateToTaskRequest() {
		
	}
	
	public AddTeammateToTaskRequest(String name, String task, String project) {
		this.name = name;
		this.task = task;
		this.project = project;
	}

	
	@Override
	public String toString() {
		return "Add Teammate Task (" + this.name + ", " + this.task + ", " + this.project + ")";
	}

}