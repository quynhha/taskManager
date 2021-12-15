package com.amazonaws.lambda.demo.http;

public class ListTeammatesForTaskRequest {
	public String taskName;
	public String projectName;
	
	public ListTeammatesForTaskRequest(String taskName,String projectName) {
		this.taskName = taskName;
		this.projectName = projectName;	
	}
	
	public ListTeammatesForTaskRequest() {
		
	}

}