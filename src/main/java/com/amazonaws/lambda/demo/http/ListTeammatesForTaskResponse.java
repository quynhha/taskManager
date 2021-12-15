package com.amazonaws.lambda.demo.http;

public class ListTeammatesForTaskResponse {
	public final int statusCode;
	public final String error;

	public ListTeammatesForTaskResponse (int code) {
		this.statusCode = code;
		this.error = "";
	}
	
	public ListTeammatesForTaskResponse (int code, String errorMessage) {
		this.statusCode = code;
		this.error = errorMessage;
	}
	
	public String toString() {
		
		return "ListTeammatesForTask" + statusCode;
	}

}
