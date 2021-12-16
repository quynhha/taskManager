package com.amazonaws.lambda.demo.http;

public class RemoveTeammateFromTaskRequest {
	public String name; 
	public String project;
	public String task;


	public RemoveTeammateFromTaskRequest(String name, String project,String task){
		this.name = name;
		this.project = project;
		this.task = task;
	}
	
	@Override
	public String toString() {
		return "Remove Teammate From Task (" + this.name + ", " + this.task + ", " + this.project + ")";
	}
	public RemoveTeammateFromTaskRequest() {}
}