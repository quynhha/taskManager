package com.amazonaws.lambda.demo.http;

import com.amazonaws.lambda.demo.model.Project;

public class GetProjectResponse {
	public final String response;
	public final int httpCode;
	public final Project project;
	
	public GetProjectResponse (Project p, int code) {
		this.project = p;
		this.response = "";
		this.httpCode = code;
	}
	
	// 200 means success
	public GetProjectResponse (int code, String errorMessage) {
		this.project = new Project();
		this.response = "";
		this.httpCode = code;
	}
	
	public String toString() {
		if (project == null) { return "NoProjectSelected"; }
		return "Project" + project.name+ ")";
	}
	
}
