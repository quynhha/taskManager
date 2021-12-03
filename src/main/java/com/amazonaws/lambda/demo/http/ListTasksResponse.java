package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;


import com.amazonaws.lambda.demo.model.Task;

public class ListTasksResponse {
	public final List<Task> list;
	public final int statusCode;
	public final String error;

	public ListTasksResponse (List<Task> list, int code) {
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}
	
	public ListTasksResponse (int code, String errorMessage) {
		this.list = new ArrayList<Task>();
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if (list == null) { return "EmptyTasksList"; }
		return "AllTasks(" + list.size() + ")";
	}
}
