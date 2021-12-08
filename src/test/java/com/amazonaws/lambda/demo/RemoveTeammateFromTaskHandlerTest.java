package com.amazonaws.lambda.demo;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskRequest;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskResponse;
import com.google.gson.Gson;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class RemoveTeammateFromTaskHandlerTest extends LambdaTest {

	 void testSuccessRemoveTeammateFromTask(String input) throws IOException {
		 	RemoveTeammateFromTaskHandler handler = new RemoveTeammateFromTaskHandler(); 
		 	RemoveTeammateFromTaskRequest req = new Gson().fromJson(input, RemoveTeammateFromTaskRequest.class);
	    	
		 	RemoveTeammateFromTaskResponse resp = handler.handleRequest(req, createContext("add to task"));
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
/*

  @Test
  public void removeTeammateTest() throws Exception{
	   TeammateDAO teammateDAO = new TeammateDAO();
	   teammateDAO.deleteTeammateFromProject("value1", "value3");
	   assert true;
  }

       // NOTE: this proliferates large number of constants! Be mindful
       @Test
       public void testShouldBeOk() {

           RemoveTeammateRequest ccr = new RemoveTeammateRequest("Test", "Razan");
           String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);

           try {
               testSuccessInput(SAMPLE_INPUT_STRING);
           } catch (IOException ioe) {
               Assert.fail("Invalid:" + ioe.getMessage());
           }
       }
       */
   
}