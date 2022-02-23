package com.amazonaws.lambda.demo;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.http.RemoveTeammateRequest;
import com.amazonaws.lambda.demo.http.RemoveTeammateResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class RemoveTeammateHandlerTest extends LambdaTest {

	 void testSuccessRemoveTeammate(String input) throws IOException {
	    	RemoveTeammateHandler handler = new RemoveTeammateHandler(); 
	    	RemoveTeammateRequest req = new Gson().fromJson(input, RemoveTeammateRequest.class);
	    	
	    	RemoveTeammateResponse resp = handler.handleRequest(req, createContext("remove"));
	    	Assert.assertEquals(200, resp.httpCode );
	    		
	    }

	    void testFailRemoveTeammate(String input, int failCode) throws IOException {
	    	RemoveTeammateHandler handler = new RemoveTeammateHandler(); 
	    	RemoveTeammateRequest req = new Gson().fromJson(input, RemoveTeammateRequest.class);
	    	
	    	RemoveTeammateResponse resp = handler.handleRequest(req, createContext("remove"));
	    	Assert.assertEquals(failCode, resp.httpCode );
	    		
	    }
	/*
   
   @Test
   public void removeTeammateTest() throws Exception{
	   TeammateDAO teammateDAO = new TeammateDAO();
	   teammateDAO.deleteTeammateFromProject("value1", "value3");
	   assert true;
   }
  */
	    
	    void testSuccessInput(String incoming) throws IOException {
            RemoveTeammateHandler handler = new RemoveTeammateHandler();
            RemoveTeammateRequest req = new Gson().fromJson(incoming, RemoveTeammateRequest.class);

            RemoveTeammateResponse resp = handler.handleRequest(req, createContext("create"));
            Assert.assertEquals(200, resp.httpCode);
        }

         void testFailInput(String incoming, int failureCode) throws IOException {
            RemoveTeammateHandler handler = new RemoveTeammateHandler();
            RemoveTeammateRequest req = new Gson().fromJson(incoming, RemoveTeammateRequest.class);

            RemoveTeammateResponse resp = handler.handleRequest(req, createContext("create"));
            Assert.assertEquals(failureCode, resp.httpCode);
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
    
}