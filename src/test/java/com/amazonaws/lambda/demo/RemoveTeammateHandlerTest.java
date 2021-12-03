package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
    @Test
    public void testRemoveTeammateSuccessHandler() {
        String name = "a";
        RemoveTeammateRequest cpr = new RemoveTeammateRequest(name); 
        
        String some_input = new Gson().toJson(cpr);
        
        try {
        	testSuccessRemoveTeammate(some_input); 
        } catch (IOException e) {
        	Assert.fail("Invalid: " + e.getMessage());
        }
        
    }
    
    
    

    

	
    
    
}
