package com.amazonaws.lambda.demo.http;




public class MarkTaskIncompleteRequest {
	public String taskName;
	public String projectName;
	
	public MarkTaskIncompleteRequest(String taskName,String projectName) {
		this.taskName = taskName;
		this.projectName = projectName;	
	}
	
	public MarkTaskIncompleteRequest() {
		
	}

}
