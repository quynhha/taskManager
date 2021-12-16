package com.amazonaws.lambda.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.amazonaws.lambda.demo.http.ListTeammatesRequest;
import com.amazonaws.lambda.demo.http.ListTeammatesResponse;
import com.google.gson.Gson;

class TestListTeammates extends LambdaTest {

	 void testSuccessInput(String input) throws IOException {
	    	ListTeammateHandler handler = new ListTeammateHandler(); 
	    	ListTeammatesRequest req = new Gson().fromJson(input, ListTeammatesRequest.class);
	    	
	    	ListTeammatesResponse resp = handler.handleRequest(req, createContext("list"));
	    	Assert.assertEquals(200, resp.httpCode);
	    }
	 
	 void testFailRemoveTeammate(String input, int failCode) throws IOException {
		 ListTeammateHandler handler = new ListTeammateHandler(); 
		 ListTeammatesRequest req = new Gson().fromJson(input, ListTeammatesRequest.class);
	    	
		 ListTeammatesResponse resp = handler.handleRequest(req, createContext("list"));
	    	Assert.assertEquals(failCode, resp.httpCode);
	    		
	    }
	
	
	@Test
    public void testShouldBeOk() {

        ListTeammatesRequest ccr = new ListTeammatesRequest("TestProject");
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);

        try {
            testSuccessInput(SAMPLE_INPUT_STRING);
        } catch (IOException ioe) {
            Assert.fail("Invalid:" + ioe.getMessage());
        }
    }
}
