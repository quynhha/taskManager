package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.ListProjectsResponse;
import com.amazonaws.lambda.demo.model.Project;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListProjectsHandlerTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	ListProjectsHandler handler = new ListProjectsHandler();

        ListProjectsResponse resp = handler.handleRequest(null, createContext("list"));
        
        boolean hasE = false;
        for (Project p : resp.list) {
        	System.out.println("found project " + p);
        	System.out.println("status" + p.archived);
        	if (p.name.equals("Project")) { hasE = true; }
        }
        Assert.assertTrue("e Needs to exist in the constants table (from tutorial) for this test case to work.", hasE);
        Assert.assertEquals(200, resp.statusCode);
    }

}