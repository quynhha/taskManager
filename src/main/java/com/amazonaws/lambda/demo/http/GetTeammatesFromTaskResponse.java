package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Teammate;
import com.amazonaws.lambda.demo.model.TeammateTask;

public class GetTeammatesFromTaskResponse {
	public final List<Teammate> list;
	public final int statusCode;
	public final String error;
	public Object httpCode;

	public GetTeammatesFromTaskResponse (List<Teammate> list, int code) {
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}
	
	public GetTeammatesFromTaskResponse (int code, String errorMessage) {
		this.list = null;
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if (list == null) { return "EmptyTasksList"; }
		return "AllTasks("  + ")";
	}
}
