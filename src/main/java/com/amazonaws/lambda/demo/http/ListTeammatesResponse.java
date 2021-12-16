package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.lambda.demo.model.Teammate;

public class ListTeammatesResponse {
	public final List<Teammate> list;
	public final int httpCode;
	public final String error;

	public ListTeammatesResponse (List<Teammate> list2, int code) {
		this.list = list2;
		this.httpCode = code;
		this.error = "";
	}
	
	public ListTeammatesResponse (int code, String errorMessage) {
		this.list = new ArrayList<Teammate>();
		this.httpCode = code;
		this.error = errorMessage;
	}
	
	/*
	public String toString() {
		if (list == null) { return "EmptyTasksList"; }
		return "AllTasks(" + list.size() + ")";
	}*/
}
