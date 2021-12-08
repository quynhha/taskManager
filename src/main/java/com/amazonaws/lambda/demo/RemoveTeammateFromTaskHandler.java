package com.amazonaws.lambda.demo;

import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskRequest;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class RemoveTeammateFromTaskHandler implements RequestHandler<RemoveTeammateFromTaskRequest, RemoveTeammateFromTaskResponse> {

	LambdaLogger logger;
	
	// To access S3 storage
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;
	
	public static final String REAL_BUCKET = "project/";
	
	/** Store into RDS.
	 * 
	 * @throws Exception 
	 */
	boolean removeTeammate(String teammateName, String projectName) throws Exception { 
		if (logger != null) { logger.log("in createProject"); }
		TeammateDAO dao = new TeammateDAO();
		
		// check if present
		if (dao.deleteTeammateFromProject(teammateName, projectName) == false) {
			return false;
		} else {
			return true;
		}

	}
	
	@Override 
	public RemoveTeammateFromTaskResponse handleRequest(RemoveTeammateFromTaskRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());

		RemoveTeammateFromTaskResponse response;
		try {
			if (removeTeammate(req.name, req.project)) {
					response = new RemoveTeammateFromTaskResponse(req.name);
			} 
			else {
					response = new RemoveTeammateFromTaskResponse(req.name, 400);
			}
			
		} catch (Exception e) {
			response = new RemoveTeammateFromTaskResponse("Unable to delete teammate: " + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}

}