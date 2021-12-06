package com.amazonaws.lambda.demo;

import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.http.AddTeammateRequest;
import com.amazonaws.lambda.demo.http.AddTeammateResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class AddTeammateHandler implements RequestHandler<AddTeammateRequest, AddTeammateResponse> {

	LambdaLogger logger;
	
	// To access S3 storage
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;
	
	public static final String REAL_BUCKET = "project/";
	
	/** Store into RDS.
	 * 
	 * @throws Exception 
	 */
	boolean addTeammate(String teammateName, String projectName) throws Exception { 
		if (logger != null) { logger.log("in createProject"); }
		TeammateDAO dao = new TeammateDAO();
		
		// check if present
		if (dao.addTeammateToProject(teammateName, projectName) != 0) {
			return true;
		} else {
			return false;
		}

	}
	
	@Override 
	public AddTeammateResponse handleRequest(AddTeammateRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());

		AddTeammateResponse response;
		try {
			if (addTeammate(req.name, req.project)) {
					response = new AddTeammateResponse(req.name);
			} 
			else {
					response = new AddTeammateResponse(req.name, 400);
			}
			
		} catch (Exception e) {
			response = new AddTeammateResponse("Unable to create teammate: " + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}

}
