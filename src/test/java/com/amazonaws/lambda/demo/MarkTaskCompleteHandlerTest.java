package com.amazonaws.lambda.demo;


import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.ArchiveProjectRequest;
import com.amazonaws.lambda.demo.http.ArchiveProjectResponse;
import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteRequest;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteResponse;
import com.amazonaws.lambda.demo.model.Project;

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
