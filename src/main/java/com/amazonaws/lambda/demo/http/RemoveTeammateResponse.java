package com.amazonaws.lambda.demo.http;

public class RemoveTeammateResponse {
	public final String response;
	public final int httpCode;
	
	public RemoveTeammateResponse (String s, int code) {
		this.response = s;
		this.httpCode = code;
	}
	
	// 200 means success
	public RemoveTeammateResponse (String s) {
		this.response = s;
		this.httpCode = 200;
	}
	
	public String toString() {
		return "Response(" + response + ")";
	}
	
}