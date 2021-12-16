package com.amazonaws.lambda.demo.http;

public class GetTeammateFromTaskRequest {
	public String taskName;
	public String projectName;

	public GetTeammateFromTaskRequest(String taskName, String projectName) {
		this.taskName = taskName;
		this.projectName = projectName;
		System.out.println(this.taskName);
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public GetTeammateFromTaskRequest() {}
}
