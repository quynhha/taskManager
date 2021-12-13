package com.amazonaws.lambda.demo.http;



public class GetPercentageCompleteResponse {
		public final int statusCode;
		public final String error;

		public GetPercentageCompleteResponse (int code) {
			this.statusCode = code;
			this.error = "";
		}
		
		public GetPercentageCompleteResponse (int code, String errorMessage) {
			this.statusCode = code;
			this.error = errorMessage;
		}
		
		public String toString() {
			
			return "PercentageComplete" + statusCode;
		}

}

