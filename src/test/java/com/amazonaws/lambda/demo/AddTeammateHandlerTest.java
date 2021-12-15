package com.amazonaws.lambda.demo;

import org.junit.Assert;
import org.junit.Test;
import com.amazonaws.lambda.demo.http.AddTeammateRequest;

public class AddTeammateHandlerTest extends LambdaTest{

    @Test
    public void Test() {
    	AddTeammateRequest incoming = new AddTeammateRequest("Akim", "a");
    	AddTeammateHandler handler = new AddTeammateHandler();
    	Assert.assertEquals(200, handler.handleRequest(incoming, createContext("add teammate")).httpCode);
    }
    

}