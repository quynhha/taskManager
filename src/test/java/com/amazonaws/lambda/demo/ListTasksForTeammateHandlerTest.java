package com.amazonaws.lambda.demo;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskRequest;
import com.amazonaws.lambda.demo.http.ListTasksForTeammateResponse;
import com.amazonaws.lambda.demo.http.ListTasksForTeammateRequest;
import com.amazonaws.lambda.demo.http.ListTasksForTeammateResponse;
import com.amazonaws.lambda.demo.model.TeammateTask;
import com.google.gson.Gson;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class ListTasksForTeammateHandlerTest extends LambdaTest {
/*
    @Test
    public void testGetList() throws IOException {
    	ListTasksForTeammateHandler handler = new ListTasksForTeammateHandler();

        ListTasksForTeammateResponse resp = handler.handleRequest(new ListTasksForTeammateRequest("Project3"), createContext("list"));
        
        boolean hasE = false;
        for (TeammateTask p : resp.list) {
        	System.out.println("found task " + p);
        	if (p.name.equals("Task0")) { hasE = true; }
        }
        Assert.assertTrue("e Needs to exist in the constants table (from tutorial) for this test case to work.", hasE);
        Assert.assertEquals(200, resp.statusCode);
    }

    void testSuccessAddTeammateToTask(String input) throws IOException {
	 	ListTasksForTeammateHandler handler = new ListTasksForTeammateHandler(); 
	 	ListTasksForTeammateRequest req = new Gson().fromJson(input, ListTasksForTeammateRequest.class);
    	
	 	ListTasksForTeammateResponse resp = handler.handleRequest(req, createContext("list task"));
    	Assert.assertEquals(200, resp.httpCode );
    		
    }
 
    void testFailAddTeammateToTask(String input, int failCode) throws IOException {
    	ListTasksForTeammateHandler handler = new ListTasksForTeammateHandler(); 
    	ListTasksForTeammateRequest req = new Gson().fromJson(input, ListTasksForTeammateRequest.class);
    	
    	ListTasksForTeammateResponse resp = handler.handleRequest(req, createContext("list task"));
    	Assert.assertEquals(failCode, resp.httpCode );
    		
    }
    
    void testSuccessInput(String incoming) throws IOException {
    	ListTasksForTeammateHandler handler = new ListTasksForTeammateHandler();
    	ListTasksForTeammateRequest req = new Gson().fromJson(incoming, ListTasksForTeammateRequest.class);

    	ListTasksForTeammateResponse resp = handler.handleRequest(req, createContext("create"));
    	Assert.assertEquals(200, resp.httpCode);
   }

    void testFailInput(String incoming, int failureCode) throws IOException {
    	ListTasksForTeammateHandler handler = new ListTasksForTeammateHandler();
    	ListTasksForTeammateRequest req = new Gson().fromJson(incoming, ListTasksForTeammateRequest.class);

    	ListTasksForTeammateResponse resp = handler.handleRequest(req, createContext("create"));
        Assert.assertEquals(failureCode, resp.httpCode);
   }
*/    
    @Test
	  public void ListTasksForTeammateTest() throws Exception{
		   TeammateTaskDAO teammateTaskDAO = new TeammateTaskDAO();
		   teammateTaskDAO.getAllTasks("Anna");
		   assert true;
	  }
}