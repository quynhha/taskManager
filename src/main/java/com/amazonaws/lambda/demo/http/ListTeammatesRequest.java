package com.amazonaws.lambda.demo.http;

public class ListTeammatesRequest {
	public String projectName;
	
	public ListTeammatesRequest(String projecName) {
		this.projectName = projectName;
	}
	public ListTeammatesRequest() {}
}
