package com.amazonaws.lambda.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.amazonaws.lambda.demo.http.ListTeammatesForTaskRequest;
import com.amazonaws.lambda.demo.http.ListTeammatesForTaskResponse;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteRequest;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteResponse;

import junit.framework.Assert;

class TestGetTeammatesFromTask extends LambdaTest{

	@Test
	public void testMarkTaskComplete() throws Exception  {

		 	String var = "a";
		 	String var2 = "Task 2";
		 	
		 	
		 	ListTeammatesForTaskRequest req = new ListTeammatesForTaskRequest(var, var2);
		 	
			ListTeammatesForTaskHandler handler = new ListTeammatesForTaskHandler();

		 	
		 	ListTeammatesForTaskResponse resp = handler.handleRequest(req, createContext("list"));
	    	
	       
	        Assert.assertEquals(200, resp.statusCode);
	    }
}

