package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.http.DeleteProjectRequest;
import com.amazonaws.lambda.demo.http.DeleteProjectResponse;
import com.amazonaws.lambda.demo.http.RemoveTeammateRequest;
import com.amazonaws.lambda.demo.model.Project;
import com.google.gson.Gson;

import junit.framework.Assert;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class DeleteProjectHandlerTest extends LambdaTest{

   

    
     void SuccessDeleteProjectHandler(String input) throws IOException{
        DeleteProjectHandler handler = new DeleteProjectHandler();
        DeleteProjectRequest req = new Gson().fromJson(input, DeleteProjectRequest.class);
        DeleteProjectResponse resp = handler.handleRequest(req, createContext("delete Project"));

        // TODO: validate output here if needed.
        Assert.assertEquals(200, resp.httpCode);
    }

    
    void FailDeleteProjectHandler(String input,int failCode) throws IOException{
        DeleteProjectHandler handler = new DeleteProjectHandler();
        DeleteProjectRequest req = new Gson().fromJson(input, DeleteProjectRequest.class);
        DeleteProjectResponse resp = handler.handleRequest(req, createContext("delete Project"));

        // TODO: validate output here if needed.
        Assert.assertEquals(failCode, resp.httpCode);
    }
    
    @Test
    public void testDeleteProjectSucccess() {
        ProjectsDAO dao = new ProjectsDAO();
        Project project = new Project();
        try {
        	SuccessDeleteProjectHandler(project.name);
        }
        catch(IOException e){
        	Assert.fail("Invalid: " + e.getMessage());
        }
    }
}
