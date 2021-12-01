package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;


import com.amazonaws.lambda.demo.model.Task;

public class ListTaskResponse {
	public final List<Task> list;
	public final int statusCode;
	public final String error;

	public ListTaskResponse (List<Task> list, int code) {
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}
	
	public ListTaskResponse (int code, String errorMessage) {
		this.list = new ArrayList<Task>();
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if (list == null) { return "EmptyTaskList"; }
		return "AllTask(" + list.size() + ")";
	}
}
