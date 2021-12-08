package com.amazonaws.lambda.demo;


import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskRequest;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskResponse;
import com.google.gson.Gson;


/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class AddTeammateToTaskHandlerTest extends LambdaTest {

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