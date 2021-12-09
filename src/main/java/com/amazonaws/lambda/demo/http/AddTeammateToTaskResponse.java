package com.amazonaws.lambda.demo.http;

public class AddTeammateToTaskResponse {
	public final String response;
	public final int httpCode;
	
	public AddTeammateToTaskResponse (String s, int code) {
		this.response = s;
		this.httpCode = code;
	}
	
	public String toString() {
		return "Response(" + this.response + ")";
	}
	
}