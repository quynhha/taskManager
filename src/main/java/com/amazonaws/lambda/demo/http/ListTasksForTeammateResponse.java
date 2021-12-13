package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;
import com.amazonaws.lambda.demo.model.TeammateTask;

public class ListTasksForTeammateResponse {
	public final List<TeammateTask> list;
	public final int statusCode;
	public final String error;
	public Object httpCode;

	public ListTasksForTeammateResponse (List<TeammateTask> list, int code) {
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}
	
	public ListTasksForTeammateResponse (int code, String errorMessage) {
		this.list = new ArrayList<TeammateTask>();
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if (list == null) { return "EmptyTasksList"; }
		return "AllTasks(" + list.size() + ")";
	}
}
