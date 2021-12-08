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
	
	// To access S3 storage
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;
	
	public static final String REAL_BUCKET = "project/";
	
	/** Store into RDS.
	 * 
	 * @throws Exception 
	 */
	boolean addTeammateToTask(String teammateName, String taskName, String projectName) throws Exception { 
		if (logger != null) { logger.log("in createProject"); }
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
			if (addTeammateToTask(req.name, req.task, req.project)) {
					response = new AddTeammateToTaskResponse(req.name);
			} 
			else {
					response = new AddTeammateToTaskResponse(req.name, 400);
			}
			
		} catch (Exception e) {
			response = new AddTeammateToTaskResponse("Unable to add teammate to task: " + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}

}