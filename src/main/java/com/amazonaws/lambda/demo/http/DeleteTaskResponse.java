package com.amazonaws.lambda.demo.http;

public class DeleteTaskResponse {
	public final int httpCode; 
	 public final String response; 
	 
	 //Sucessfully remove the Teammate
	 public DeleteTaskResponse(String s) {
		 this.response = s; 
		 this.httpCode = 200;
	 }
	 
	 public DeleteTaskResponse(String s, int i) {
		 this.response = s; 
		 this.httpCode = i;
	 }
	
	 public String toString() {
		 return response; 
	 }
}
