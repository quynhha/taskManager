package com.amazonaws.lambda.demo.http;

public class ArchiveProjectRequest {
	public String projectName;
	
	public ArchiveProjectRequest(String projectName) {
		this.projectName = projectName;
	}
	
	public ArchiveProjectRequest() {
		
	}

}
