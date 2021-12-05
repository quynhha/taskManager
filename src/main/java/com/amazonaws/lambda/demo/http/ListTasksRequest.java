package com.amazonaws.lambda.demo.http;

public class ListTasksRequest {
	
	public String projectName;
	
	public ListTasksRequest(String projectName) {
		this.projectName = projectName;
	}
	
	public ListTasksRequest() {
		
	}

}
