package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Project;

public class ListProjectsResponse {
	public final List<Project> list;
	public final int statusCode;
	public final String error;

	public ListProjectsResponse (List<Project> list, int code) {
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}
	
	public ListProjectsResponse (int code, String errorMessage) {
		this.list = new ArrayList<Project>();
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if (list == null) { return "EmptyProjectsList"; }
		return "AllProjects(" + list.size() + ")";
	}
}
