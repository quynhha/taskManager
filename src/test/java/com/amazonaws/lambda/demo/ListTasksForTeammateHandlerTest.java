package com.amazonaws.lambda.demo;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskRequest;
import com.amazonaws.lambda.demo.http.CreateTaskRequest;
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
    @Test		//check if list is empty
    public void testGetList() throws IOException {
    	ListTasksForTeammateHandler handler = new ListTasksForTeammateHandler();
        ListTasksForTeammateResponse resp = handler.handleRequest(new ListTasksForTeammateRequest("Anna","a"), createContext("list"));
        boolean listCheck = resp.list.isEmpty() ? true : false;
        Assert.assertFalse(listCheck);
        Assert.assertEquals(200, resp.statusCode);
    }
    */
	
	
    
    void testSuccessListTasksForTeammate(String input) throws IOException {
	 	ListTasksForTeammateHandler handler = new ListTasksForTeammateHandler(); 
	 	ListTasksForTeammateRequest req = new Gson().fromJson(input, ListTasksForTeammateRequest.class);
    	
	 	ListTasksForTeammateResponse resp = handler.handleRequest(req, createContext("list tasks"));
    	Assert.assertEquals(200, resp.httpCode );
    		
    }
 
    void testFailListTasksForTeammate(String input, int failCode) throws IOException {
    	ListTasksForTeammateHandler handler = new ListTasksForTeammateHandler(); 
    	ListTasksForTeammateRequest req = new Gson().fromJson(input, ListTasksForTeammateRequest.class);
    	
    	ListTasksForTeammateResponse resp = handler.handleRequest(req, createContext("list tasks"));
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
    
    
	
    @Test
	  public void ListTasksForTeammateTest() throws Exception{
		   TeammateTaskDAO teammateTaskDAO = new TeammateTaskDAO();
		   teammateTaskDAO.getAllTasks("Anna", "a");
		   
		   CreateTaskHandler handler = new CreateTaskHandler();
		   CreateTaskRequest req = new CreateTaskRequest(teammateTaskDAO.toString(), "Project");
		   handler.handleRequest(req, createContext("ListTasksForTeammate"));
	        
	        

		   
		   assert true;
	  }
}