package com.amazonaws.lambda.demo.http;

public class ListTasksForTeammateRequest {
	
	public String teammateName;
	public String projectName;
	
	public ListTasksForTeammateRequest(String teammateName, String projectName) {
		this.teammateName = teammateName;
		this.projectName = projectName;
	}
	
	public ListTasksForTeammateRequest() {}
}
