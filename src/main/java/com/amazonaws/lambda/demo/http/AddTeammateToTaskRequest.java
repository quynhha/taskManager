package com.amazonaws.lambda.demo.http;

public class AddTeammateToTaskRequest {
	public String name; 
	public String task;
	public String project;
	
	@Override
	public String toString() {
		return "Add Teammate Task (" + this.name + ", " + this.task + ", " + this.project + ")";
	}

}