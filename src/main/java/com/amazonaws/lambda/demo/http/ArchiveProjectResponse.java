package com.amazonaws.lambda.demo.http;

public class ArchiveProjectResponse {
		public final int statusCode;
		public final String error;

		public ArchiveProjectResponse (int code) {
			this.statusCode = code;
			this.error = "";
		}
		
		public ArchiveProjectResponse (int code, String errorMessage) {
			this.statusCode = code;
			this.error = errorMessage;
		}
		
		public String toString() {
			
			return "ArchivedProject" + statusCode;
		}

}
