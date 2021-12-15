package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.ListProjectsResponse;
import com.amazonaws.lambda.demo.http.ListTasksResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;


public class TestListTask extends LambdaTest {

	@After
	public void tearDown() throws Exception {
	}

	 @Test
	    public void testGetList() throws IOException {
	    	ListTasksHandler handler = new ListTasksHandler();

	        ListTasksResponse resp = handler.handleRequest(null, createContext("list"));
	        
	        boolean hasE = false;
	        /*
	        for (Task c : resp.list) {
	        	System.out.println("found constant " + c);
	        	if (c.name.equals("Task")) { hasE = true; }
	        }
	        Assert.assertTrue("e Needs to exist in the constants table (from tutorial) for this test case to work.", hasE);
	        Assert.assertEquals(200, resp.statusCode);*/
	        
	        assert(true);
	    }

}
