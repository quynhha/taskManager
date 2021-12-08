package com.amazonaws.lambda.demo;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskRequest;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskResponse;
import com.amazonaws.services.kinesisanalytics.model.LambdaOutput;
import com.google.gson.Gson;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class AddTeammateToTaskHandlerTest extends LambdaTest {
	
	//Testing TeammateTaskDAO
	/*
	  @Test
	  public void tesstDAO() throws Exception{
		  TeammateTaskDAO dao = new TeammateTaskDAO();
		  dao.addTeammateToTask("kassa", "v", "a");
		  assert(true);
	  }
	 */ 
	  
	 void testSuccessAddTeammateToTask(String input) throws IOException {
		 	AddTeammateToTaskHandler handler = new AddTeammateToTaskHandler(); 
		 	AddTeammateToTaskRequest req = new Gson().fromJson(input, AddTeammateToTaskRequest.class);
	    	
		 	AddTeammateToTaskResponse resp = handler.handleRequest(req, createContext("add to task"));
	    	Assert.assertEquals(200, resp.httpCode );
	    		
	    }
	 
	    void testFailAddTeammateToTask(String input, int failCode) throws IOException {
	    	AddTeammateToTaskHandler handler = new AddTeammateToTaskHandler(); 
	    	AddTeammateToTaskRequest req = new Gson().fromJson(input, AddTeammateToTaskRequest.class);
	    	
	    	AddTeammateToTaskResponse resp = handler.handleRequest(req, createContext("add to task"));
	    	Assert.assertEquals(failCode, resp.httpCode );
	    		
	    }
	    
	    void testSuccessInput(String incoming) throws IOException {
	    	AddTeammateToTaskHandler handler = new AddTeammateToTaskHandler();
	    	AddTeammateToTaskRequest req = new Gson().fromJson(incoming, AddTeammateToTaskRequest.class);

	    	AddTeammateToTaskResponse resp = handler.handleRequest(req, createContext("create"));
	    	Assert.assertEquals(200, resp.httpCode);
       }

        void testFailInput(String incoming, int failureCode) throws IOException {
        	AddTeammateToTaskHandler handler = new AddTeammateToTaskHandler();
        	AddTeammateToTaskRequest req = new Gson().fromJson(incoming, AddTeammateToTaskRequest.class);

        	AddTeammateToTaskResponse resp = handler.handleRequest(req, createContext("create"));
            Assert.assertEquals(failureCode, resp.httpCode);
       }
        
        @Test
		  public void addTeammateToTaskTest() throws Exception{
			   TeammateTaskDAO teammateTaskDAO = new TeammateTaskDAO();
			   teammateTaskDAO.addTeammateToTask("Razan", "Task2", "Project");
			   assert true;
		  }
   
}