package com.amazonaws.lambda.demo.http;

public class RemoveTeammateFromTaskRequest {
	public String name; 
	public String project;
	public String task;
	
	public String getName() {
		return name;
	}
	
	public String getTask() {
		return this.task;
	}
	
	public void setTask(String project) {
		this.project = task;
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
	
	public RemoveTeammateFromTaskRequest(String n , String t) {
		this.name = n; 
		this.task = t;
	}
	
	public String toString() {
		return "Add Teammate(" + name + "," + name + ")";
	}
	
	public RemoveTeammateFromTaskRequest() {}
}