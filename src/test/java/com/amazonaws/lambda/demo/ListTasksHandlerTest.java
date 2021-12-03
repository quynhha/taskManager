package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.ListProjectsResponse;
import com.amazonaws.lambda.demo.http.ListTasksResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListTasksHandlerTest extends LambdaTest {
	
    @Test
    public void testGetList() throws IOException {
    	ListTasksHandler handler = new ListTasksHandler();

        ListTasksResponse resp = handler.handleRequest(null, createContext("list"));
        
        boolean hasE = false;
        for (Task p : resp.list) {
        	System.out.println("found task " + p);
        	if (p.name.equals("Task")) { hasE = true; }
        }
        Assert.assertTrue("e Needs to exist in the constants table (from tutorial) for this test case to work.", hasE);
        Assert.assertEquals(200, resp.statusCode);
    }

}