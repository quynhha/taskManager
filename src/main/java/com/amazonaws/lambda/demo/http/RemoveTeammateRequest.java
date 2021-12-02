package com.amazonaws.lambda.demo.http;

public class RemoveTeammateRequest {
	
	public final String name; 
	
	public RemoveTeammateRequest(String n) {
		this.name = n;
	}
	
	public String getName() {
		return name; 
	}
	
	public String toString() {
		return "Remove this teammate: " + name + "."; 
	}
}
