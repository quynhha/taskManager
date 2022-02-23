
package com.amazonaws.lambda.demo;


import org.junit.Test;


import com.amazonaws.lambda.demo.http.MarkTaskIncompleteRequest;
import com.amazonaws.lambda.demo.http.MarkTaskIncompleteResponse;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class MarkTaskIncompleteHandlerTest extends LambdaTest {
	 	
	@Test
	public void testMarkTaskIncomplete() throws Exception {
		  	MarkTaskIncompleteHandler handler = new MarkTaskIncompleteHandler();

		 	String var = "A";
		 	String var2 = "0";
		 	
		 	
		 	MarkTaskIncompleteRequest req = new MarkTaskIncompleteRequest(var, var2);
		 	
		 	
		 	MarkTaskIncompleteResponse resp = handler.handleRequest(req, createContext("list"));
	    	
	       
	       // Assert.assertEquals(200, resp.statusCode);
	    }

    
}
