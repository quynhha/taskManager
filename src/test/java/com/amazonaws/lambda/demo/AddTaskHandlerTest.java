package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.util.UUID;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import com.amazonaws.lambda.demo.http.CreateTaskRequest;
import com.amazonaws.lambda.demo.http.CreateTaskResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;



/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class AddTaskHandlerTest extends LambdaTest{

	
	
	 void testSuccessInput(String incoming) throws IOException {
    	CreateTaskHandler handler = new CreateTaskHandler();
    	CreateTaskRequest req = new Gson().fromJson(incoming, CreateTaskRequest.class);
       
        CreateTaskResponse resp = handler.handleRequest(req, createContext("create"));
        Assert.assertEquals(200, resp.httpCode);
    }
	
	 void testFailInput(String incoming, int failureCode) throws IOException {
		CreateTaskHandler handler = new CreateTaskHandler();
		CreateTaskRequest req = new Gson().fromJson(incoming, CreateTaskRequest.class);

		CreateTaskResponse resp = handler.handleRequest(req, createContext("create"));
        Assert.assertEquals(failureCode, resp.httpCode);
    }

   
    // NOTE: this proliferates large number of constants! Be mindful
    @Test
    public void testShouldBeOk() {
    	int rndNum = (int)(990*(Math.random()));
    	String var = "ThrowAway" + rndNum;
    	
    	CreateTaskRequest ccr = new CreateTaskRequest(var, (UUID.randomUUID()), "abc3");
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        
        try {
        	testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
        	Assert.fail("Invalid:" + ioe.getMessage());
        }
    }
    

}