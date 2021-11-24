package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.lambda.demo.http.CreateProjectRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;

import edu.wpi.cs.heineman.demo.CreateConstantHandler;
import edu.wpi.cs.heineman.demo.http.CreateConstantRequest;
import edu.wpi.cs.heineman.demo.http.CreateProjectResponse;

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
	
}
