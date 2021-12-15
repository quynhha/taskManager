package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;
import com.amazonaws.lambda.demo.model.TeammateTask;

public class GetTeammatesFromTaskResponse {
	public final int list;
	public final int statusCode;
	public final String error;
	public Object httpCode;

	public GetTeammatesFromTaskResponse (int list, int code) {
		this.list = list;
		this.statusCode = code;
		this.error = "";
	}
	
	public GetTeammatesFromTaskResponse (int code, String errorMessage) {
		this.list = -1;
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		if (list == -1) { return "EmptyTasksList"; }
		return "AllTasks("  + ")";
	}
}
