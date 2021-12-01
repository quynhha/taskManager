package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;


import com.amazonaws.lambda.demo.model.Task;

public class GetTaskResponse {
	public final String response;
	public final int httpCode;
	public final Task task;
	public final List<Task> taskList;
	
	public GetTaskResponse (Task t, List<Task> tr , int code, String s) {
		this.task = t;
		this.response = s;
		this.httpCode = code;
		this.taskList = tr;
	}
	
	
	public GetTaskResponse (Task p, List<Task> pr) {
		this.task = p;
		this.response = "";
		this.httpCode = 200;
		this.taskList = pr;
	}
	// 200 means success
	public GetTaskResponse (int code, String errorMessage) {
		this.task = new Task();
		this.response = "";
		this.httpCode = code;
		this.taskList = new ArrayList<Task>();
	}
	
	public String toString() {
		if (task == null) { return "NoTaskSelected"; }
		return "Task" + task.name+ ")";
	}
	
}
