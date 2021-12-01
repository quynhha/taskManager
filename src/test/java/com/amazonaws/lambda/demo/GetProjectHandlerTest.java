package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.model.Project;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GetProjectHandlerTest extends LambdaTest {
	 	
	@Test
	public void testGetProject() throws IOException {
		 	GetProjectHandler handler = new GetProjectHandler();

		 	String var = "a";
		 	GetProjectRequest req = new GetProjectRequest(var);
		 	
	        GetProjectResponse resp = handler.handleRequest(req, createContext("list"));
	    	System.out.println("Hello World");

	        boolean hasE = false;
	        for (Project p : resp.projectList) {
	        	//.out.println("Hello World");
	        	System.out.println(hasE);
	        	if (p.name.equals("Project")) { hasE = true; }
	        	System.out.println(hasE);
	        }
	        
	        
	        Assert.assertTrue("There needs to be a project gotten.", hasE);
	        Assert.assertEquals(200, resp.response);
	    }

    
}
