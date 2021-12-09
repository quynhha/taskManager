package com.amazonaws.lambda.demo.http;

public class AddTeammateToTaskRequest {
	private String name; 
	private String task;
	private String project;
	
	public String getName() {
		return this.name;
	}
	
	public String getTask() {
		return this.task;
	}
	
	public String getProject() {
		return project;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
	public void setProject(String project) {
		this.project = project;
	}
	
	@Override
	public String toString() {
		return "Add Teammate Task (" + this.name + ", " + this.task + ", " + this.project + ")";
	}

}