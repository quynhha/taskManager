package com.amazonaws.lambda.demo.http;

public class AddTeammateToTaskRequest {
	public String name; 
	public String task;
	public String project;
	
	public String getName() {
		return name;
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
	
	public AddTeammateToTaskRequest(String name, String task, String project) {
		this.name = name; 
		this.task = task;
		this.project = project;
	}
	
	public String toString() {
		return "Add Teammate(" + this.name + ", " + this.task + ", " + this.project + ")";
	}
	
	public AddTeammateToTaskRequest() {
		
	}
}