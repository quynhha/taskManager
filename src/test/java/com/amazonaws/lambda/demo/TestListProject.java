package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.ListProjectsResponse;
import com.amazonaws.lambda.demo.model.Project;


public class TestListProject extends LambdaTest {

	@After
	public void tearDown() throws Exception {
	}

	 @Test
	    public void testGetList() throws IOException {
	    	ListProjectsHandler handler = new ListProjectsHandler();

	        ListProjectsResponse resp = handler.handleRequest(null, createContext("list"));
	        
	        boolean hasE = false;
	        for (Project c : resp.list) {
	        	System.out.println("found constant " + c);
	        	if (c.name.equals("Project")) { hasE = true; }
	        }
	        Assert.assertTrue("e Needs to exist in the constants table (from tutorial) for this test case to work.", hasE);
	        Assert.assertEquals(200, resp.statusCode);
	    }

}
