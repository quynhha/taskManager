package com.amazonaws.lambda.demo.http;

public class RemoveTeammateResponse {
	
	 public final int httpCode; 
	 public final String response; 
	 
	 //Sucessfully remove the Teammate
	 public RemoveTeammateResponse(String s) {
		 this.response = s; 
		 this.httpCode = 200;
	 }
	
	 public RemoveTeammateResponse(String s, int i) {
		 this.response = s; 
		 this.httpCode = i;
	 }
	
	 public String toString() {
		 return response; 
	 }
}
