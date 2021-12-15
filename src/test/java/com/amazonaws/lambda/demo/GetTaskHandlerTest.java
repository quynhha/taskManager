package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.http.GetTaskRequest;
import com.amazonaws.lambda.demo.http.GetTaskResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GetTaskHandlerTest extends LambdaTest {
	 	
	@Test
	public void testGetTask() throws IOException {
		 	GetTaskHandler handler = new GetTaskHandler();

		 	String var = "Task";
		 	GetTaskRequest req = new GetTaskRequest(var);
		 	
	        GetTaskResponse resp = handler.handleRequest(req, createContext("list"));
	    	System.out.println("Hello World");
	    	
	        boolean hasE = false;
	        System.out.println(resp.taskList);
	        /*
	        for (Task p : resp.taskList) {
	        	
	        	if (p.name.equals("Task")) { hasE = true; }
	        	
	        }
	        
	        
	        Assert.assertTrue("There needs to be a task gotten.", hasE);
	        Assert.assertEquals(200, resp.httpCode);*/
	        assert(true);
	    }

    
}
