package com.amazonaws.lambda.demo;

import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskRequest;
import com.amazonaws.lambda.demo.http.AddTeammateToTaskResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class AddTeammateToTaskHandler implements RequestHandler<AddTeammateToTaskRequest, AddTeammateToTaskResponse> {

	LambdaLogger logger;

	boolean addTeammateToTask(String teammateName, String taskName, String projectName) throws Exception { 
		if (logger != null) { logger.log(" in addTeamMateToTask"); }
		TeammateTaskDAO dao = new TeammateTaskDAO();
		
		// check if present
		if (dao.addTeammateToTask(teammateName, taskName, projectName) != 0) {
			return true;
		} else {
			return false;
		}

	}
	
	@Override 
	public AddTeammateToTaskResponse handleRequest(AddTeammateToTaskRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());
        
		AddTeammateToTaskResponse response;
		try {
			if (addTeammateToTask(req.getName(), req.getTask(), req.getProject())) {
					response = new AddTeammateToTaskResponse(req.getName(), 200);
			} 
			else {
					response = new AddTeammateToTaskResponse(req.getName(), 400);
			}
			
		} catch (Exception e) {
			response = new AddTeammateToTaskResponse("Unable to add teammate to task: " + req.getName() + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}

}