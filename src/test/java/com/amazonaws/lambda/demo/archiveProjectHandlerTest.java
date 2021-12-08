package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.ArchiveProjectRequest;
import com.amazonaws.lambda.demo.http.ArchiveProjectResponse;
import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.model.Project;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class archiveProjectHandlerTest extends LambdaTest {
	 	
	@Test
	public void testArchiveProject() throws IOException {
		 	ArchiveProjectHandler handler = new ArchiveProjectHandler();

		 	String var = "Project";
		 	ArchiveProjectRequest req = new ArchiveProjectRequest(var);
		 	
	        ArchiveProjectResponse resp = handler.handleRequest(req, createContext("list"));
	    	
	       
	        Assert.assertEquals(200, resp.statusCode);
	    }

    
}
