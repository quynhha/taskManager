package com.amazonaws.lambda.demo.http;



public class MarkTaskCompleteRequest {
	public String taskName;
	public String projectName;
	
	public MarkTaskCompleteRequest(String taskName,String projectName) {
		this.taskName = taskName;
		this.projectName = projectName;	
	}
	
	public MarkTaskCompleteRequest() {
		
	}

}
