package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.util.UUID;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.CreateProjectRequest;
import com.amazonaws.lambda.demo.http.CreateProjectResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;



/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class AddProjectHandlerTest extends LambdaTest{

	void testSuccessInput(String incoming) throws IOException {
    	CreateProjectHandler handler = new CreateProjectHandler();
    	CreateProjectRequest req = new Gson().fromJson(incoming, CreateProjectRequest.class);
       
        com.amazonaws.lambda.demo.http.CreateProjectResponse resp = handler.handleRequest(req, createContext("create"));
        Assert.assertEquals(200, resp.httpCode);
    }
	
	void testFailInput(String incoming, int failureCode) throws IOException {
		CreateProjectHandler handler = new CreateProjectHandler();
		CreateProjectRequest req = new Gson().fromJson(incoming, CreateProjectRequest.class);

		CreateProjectResponse resp = handler.handleRequest(req, createContext("create"));
        Assert.assertEquals(failureCode, resp.httpCode);
    }

   
    // NOTE: this proliferates large number of constants! Be mindful
    @Test
    public void testShouldBeOk() {
    	int rndNum = (int)(990*(Math.random()));
    	String var = "throwAway" + rndNum;
    	
    	CreateProjectRequest ccr = new CreateProjectRequest(var, (UUID.randomUUID()));
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        
        try {
        	testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
    }
    
    
    @Test
    public void testGarbageInput() {
    	String SAMPLE_INPUT_STRING = "{\"sdsd\": \"e3\", \"hgfgdfgdfg\": \"this is not a project\"}";
        
        try {
        	testFailInput(SAMPLE_INPUT_STRING, 400);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
    }
    
}