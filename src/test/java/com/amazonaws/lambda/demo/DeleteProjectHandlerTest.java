package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.util.UUID;

import org.junit.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.http.CreateProjectRequest;
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

   

    
     void SuccessDeleteProjectHandler(DeleteProjectRequest input) throws IOException{
        DeleteProjectHandler handler = new DeleteProjectHandler();
        DeleteProjectResponse resp = handler.handleRequest(input, createContext("delete Project"));

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
        
    	int rndNum = (int)(990*(Math.random()));
    	String var = "throwAway" + rndNum;
    	
    	CreateProjectRequest ccr = new CreateProjectRequest(var, (UUID.randomUUID()));
        String SAMPLE_INPUT_STRING = new Gson().toJson(ccr);  
        CreateProjectHandler handler = new CreateProjectHandler();
    	CreateProjectRequest req = new Gson().fromJson(SAMPLE_INPUT_STRING, CreateProjectRequest.class);
        
    	
    	
    	
    	ProjectsDAO dao = new ProjectsDAO();
        Project project = new Project();
        //dao.addProject(project);

        DeleteProjectRequest request = new DeleteProjectRequest(SAMPLE_INPUT_STRING);
        try {
        	SuccessDeleteProjectHandler(request);
        }
        catch(IOException e){
        	Assert.fail("Invalid: " + e.getMessage());
        }
    }
}
