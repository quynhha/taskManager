package com.amazonaws.lambda.demo.http;



public class GetPercentageCompleteResponse {
		public final int statusCode;
		public final String error;
		public int percentageComplete;

//		public GetPercentageCompleteResponse (int code) {
//			this.statusCode = code;
//			this.error = "";
//
//		}
		
		public GetPercentageCompleteResponse (int code, String errorMessage , int percentageComplete) {
			this.statusCode = code;
			this.error = errorMessage;
			this.percentageComplete = percentageComplete;
		}
		
		public String toString() {
			
			return "PercentageComplete" + statusCode + percentageComplete;
			
		}

}

