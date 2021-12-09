package com.amazonaws.lambda.demo;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskRequest;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskResponse;
import com.google.gson.Gson;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class RemoveTeammateFromTaskHandlerTest extends LambdaTest {
	 
	/*
	@Test
	  public void removeTeammateFromTaskTest() throws Exception{
		   TeammateTaskDAO teammateTaskDAO = new TeammateTaskDAO();
		   teammateTaskDAO.removeTeammateFromTask("Artwell", "Go Jogging", "Workout");
		   assert true;
	  }  
	
	*/
	
	 void testSuccessRemoveTeammateFromTask(String input) throws IOException {
		 	RemoveTeammateFromTaskHandler handler = new RemoveTeammateFromTaskHandler(); 
		 	RemoveTeammateFromTaskRequest req = new Gson().fromJson(input, RemoveTeammateFromTaskRequest.class);
	    	
		 	RemoveTeammateFromTaskResponse resp = handler.handleRequest(req, createContext("remove from task"));
	    	Assert.assertEquals(200, resp.httpCode );
	    		
	    }
	 
	    void testFailRemoveTeammateFromTask(String input, int failCode) throws IOException {
	    	RemoveTeammateFromTaskHandler handler = new RemoveTeammateFromTaskHandler(); 
	    	RemoveTeammateFromTaskRequest req = new Gson().fromJson(input, RemoveTeammateFromTaskRequest.class);
	    	
	    	RemoveTeammateFromTaskResponse resp = handler.handleRequest(req, createContext("remove from task"));
	    	Assert.assertEquals(failCode, resp.httpCode );
	    		
	    }
	    
	    void testSuccessInput(String incoming) throws IOException {
	    	RemoveTeammateFromTaskHandler handler = new RemoveTeammateFromTaskHandler();
	    	RemoveTeammateFromTaskRequest req = new Gson().fromJson(incoming, RemoveTeammateFromTaskRequest.class);

	    	RemoveTeammateFromTaskResponse resp = handler.handleRequest(req, createContext("create"));
	    	Assert.assertEquals(200, resp.httpCode);
       }

        void testFailInput(String incoming, int failureCode) throws IOException {
        	RemoveTeammateFromTaskHandler handler = new RemoveTeammateFromTaskHandler();
        	RemoveTeammateFromTaskRequest req = new Gson().fromJson(incoming, RemoveTeammateFromTaskRequest.class);

        	RemoveTeammateFromTaskResponse resp = handler.handleRequest(req, createContext("create"));
            Assert.assertEquals(failureCode, resp.httpCode);
       }
        
        @Test
		  public void removeTeammateFromTaskTest() throws Exception{
			   TeammateTaskDAO teammateTaskDAO = new TeammateTaskDAO();
			   teammateTaskDAO.removeTeammateFromTask("Artwell", "Go Jogging", "Workout");
			   assert true;
		  }
       
}