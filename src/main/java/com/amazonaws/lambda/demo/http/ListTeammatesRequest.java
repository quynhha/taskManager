package com.amazonaws.lambda.demo.http;

public class ListTeammatesRequest {
	public String projectName;
	
	public ListTeammatesRequest(String projectName) {
		this.projectName = projectName;
		System.out.println(this.projectName);
	}
	public ListTeammatesRequest() {}
}
