package com.amazonaws.lambda.demo;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskRequest;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskResponse;
import com.google.gson.Gson;


public class AddTeammateToTaskHandlerTest extends LambdaTest {
	
	//Testing TeammateTaskDAO
	
	  @Test
	  public void tesstDAO() throws Exception{
		  TeammateTaskDAO dao = new TeammateTaskDAO();
		  dao.addTeammateToTask("kassaf", "hv", "au");
		  assert(true);
	  }
	  
        
        @Test
		  public void addTeammateToTaskTest() throws Exception{
			   TeammateTaskDAO teammateTaskDAO = new TeammateTaskDAO();
			   teammateTaskDAO.addTeammateToTask("Razan", "Task2", "Project");
			   assert true;
		  }
   
}