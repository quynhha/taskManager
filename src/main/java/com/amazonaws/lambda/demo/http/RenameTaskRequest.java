package com.amazonaws.lambda.demo.http;



public class RenameTaskRequest {
	public final String taskName;
	public final String projectName;
	public final String newName;
	
	public RenameTaskRequest(String taskName, String projectName, String newName) {
		this.taskName = taskName;
		this.newName = newName;
		this.projectName = projectName;
	}
	
	/*public String getName() {
		return name;
	}*/
	
	public String toString() {
		return "Rename this Task: " + taskName + "."; 
	}
	
	public RenameTaskRequest() {
		this.taskName = "";
		this.newName = "";
		this.projectName = "";
	}
	
}
