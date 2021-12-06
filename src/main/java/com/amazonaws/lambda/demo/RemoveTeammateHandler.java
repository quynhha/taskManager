package com.amazonaws.lambda.demo;

import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.http.RemoveTeammateRequest;
import com.amazonaws.lambda.demo.http.RemoveTeammateResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class RemoveTeammateHandler implements RequestHandler<RemoveTeammateRequest, RemoveTeammateResponse> {

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
	public RemoveTeammateResponse handleRequest(RemoveTeammateRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());

		RemoveTeammateResponse response;
		try {
			if (removeTeammate(req.name, req.project)) {
					response = new RemoveTeammateResponse(req.name);
			} 
			else {
					response = new RemoveTeammateResponse(req.name, 400);
			}
			
		} catch (Exception e) {
			response = new RemoveTeammateResponse("Unable to delete teammate: " + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}

}