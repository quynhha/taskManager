package com.amazonaws.lambda.demo.http;




import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Task;

@SuppressWarnings("unused")
public class MarkTaskIncompleteResponse {
		public final int statusCode;
		public final String error;

		public MarkTaskIncompleteResponse (int code) {
			this.statusCode = code;
			this.error = "";
		}
		
		public MarkTaskIncompleteResponse (int code, String errorMessage) {
			this.statusCode = code;
			this.error = errorMessage;
		}
		
		public String toString() {
			
			return "MarkedTaskIncomplete" + statusCode;
		}

}
