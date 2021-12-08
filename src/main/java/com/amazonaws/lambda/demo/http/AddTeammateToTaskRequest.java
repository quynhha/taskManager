package com.amazonaws.lambda.demo.http;

public class AddTeammateToTaskRequest {
	public String name; 
	public String task;
	
	public String getName() {
		return name;
	}
	
	public String getTask() {
		return this.task;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public AddTeammateToTaskRequest(String n , String t) {
		this.name = n; 
		this.task = t;
	}
	
	public String toString() {
		return "Add Teammate(" + name + "," + name + ")";
	}
	
	public AddTeammateToTaskRequest() {}
}