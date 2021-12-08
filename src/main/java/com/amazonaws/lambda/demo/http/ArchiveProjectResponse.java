package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Task;

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
