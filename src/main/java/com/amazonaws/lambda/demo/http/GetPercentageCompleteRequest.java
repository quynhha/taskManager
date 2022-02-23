package com.amazonaws.lambda.demo.http;

//public class GetPercentageCompleteRequest {
//
//	public Object projectName;
//
//}


public class GetPercentageCompleteRequest {
	public int  PercentageComplete;
	public String projectName;
	public GetPercentageCompleteRequest(String projectName) {
		this.projectName = projectName;
	}
	
	public GetPercentageCompleteRequest() {
		
	}

}

