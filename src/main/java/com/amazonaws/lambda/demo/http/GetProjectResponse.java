package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Project;

public class GetProjectResponse {
	public final String response;
	public final int httpCode;
	public final Project project;
	public final List<Project> projectList;
	
	public GetProjectResponse (Project p, List<Project> pr , int code) {
		this.project = p;
		this.response = "";
		this.httpCode = code;
		this.projectList = pr;
	}
	
	// 200 means success
	public GetProjectResponse (int code, String errorMessage) {
		this.project = new Project();
		this.response = "";
		this.httpCode = code;
		this.projectList = new ArrayList<Project>();
	}
	
	public String toString() {
		if (project == null) { return "NoProjectSelected"; }
		return "Project" + project.name+ ")";
	}
	
}
