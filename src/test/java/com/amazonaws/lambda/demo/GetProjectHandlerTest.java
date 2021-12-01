package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.http.ListProjectsResponse;
import com.amazonaws.lambda.demo.model.Project;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class GetProjectHandlerTest extends LambdaTest {
	 @Test
	    public void testGetList() throws IOException {
	    	GetProjectHandler handler = new GetProjectHandler();

	        GetProjectResponse resp = handler.handleRequest(null, createContext("list"));
	        
	        boolean hasE = false;

	        
	        if(resp.project != null) {
	        	hasE = true;
	        }
	        
	        Assert.assertTrue("There needs to be a project gotten.", hasE);
	        Assert.assertEquals(200, resp.response);
	    }

    
}
