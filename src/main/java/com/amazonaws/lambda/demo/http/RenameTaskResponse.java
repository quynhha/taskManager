package com.amazonaws.lambda.demo.http;

import com.amazonaws.services.lambda.runtime.Context;



public class RenameTaskResponse {
	public final String response;
	public final int httpCode;
	
	public RenameTaskResponse (String s, int code) {
		this.response = s;
		this.httpCode = code;
	}
	
	// 200 means success
	public RenameTaskResponse (String s) {
		this.response = s;
		this.httpCode = 200;
	}
	
	public String toString() {
		return "Response(" + response + ")";
	}
	
}