package com.amazonaws.lambda.demo;


import org.junit.Test;

import com.amazonaws.lambda.demo.http.MarkTaskCompleteRequest;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteResponse;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class MarkTaskCompleteHandlerTest extends LambdaTest {
	 	
	@Test
	public void testMarkTaskComplete() throws Exception {
		  	MarkTaskCompleteHandler handler = new MarkTaskCompleteHandler();

		 	String var = "A";
		 	String var2 = "0";
		 	
		 	
		 	MarkTaskCompleteRequest req = new MarkTaskCompleteRequest(var, var2);
		 	
		 	
		 	MarkTaskCompleteResponse resp = handler.handleRequest(req, createContext("list"));
	    	
	       
	       // Assert.assertEquals(200, resp.statusCode);
	    }

    
}
