package com.amazonaws.lambda.demo.http;

public class ListTasksForTeammateRequest {
	
	public String teammateName;
	
	public ListTasksForTeammateRequest(String teammateName) {
		this.teammateName = teammateName;
	}
	
	public ListTasksForTeammateRequest() {}
}
