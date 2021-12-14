package com.amazonaws.lambda.demo;


import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.GetPercentageCompleteRequest;
import com.amazonaws.lambda.demo.http.GetPercentageCompleteResponse;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GetPercentageCompleteHandlerTest extends LambdaTest {
	 	
	@Test
	public void testPercentageComplete() throws IOException {
		GetPercentageCompleteHandler handler = new GetPercentageCompleteHandler();

		 	String var = "abc4";
		 	GetPercentageCompleteRequest req = new GetPercentageCompleteRequest(var);
		 	
		 	GetPercentageCompleteResponse resp = handler.handleRequest(req, createContext("list"));
	    	
	       
	        Assert.assertEquals(200, resp.statusCode);
	    }

    
}
