package com.amazonaws.lambda.demo.http;

public class DeleteProjectResponse {
	public final int httpCode; 
	 public final String response; 
	 
	 //Sucessfully remove the Teammate
	 public DeleteProjectResponse(String s) {
		 this.response = s; 
		 this.httpCode = 200;
	 }
	 
	 public DeleteProjectResponse(String s, int i) {
		 this.response = s; 
		 this.httpCode = i;
	 }
	
	 public String toString() {
		 return response; 
	 }
}
