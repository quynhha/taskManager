package com.amazonaws.lambda.demo;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.http.CreateProjectRequest;
import com.amazonaws.lambda.demo.http.CreateProjectResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class CreateProjectHandler implements RequestHandler<CreateProjectRequest, CreateProjectResponse> {

	LambdaLogger logger;
	
	// To access S3 storage
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;
	
	public static final String REAL_BUCKET = "project/";
	
	/** Store into RDS.
	 * 
	 * @throws Exception 
	 */
	boolean createProject(String name) throws Exception { 
		if (logger != null) { logger.log("in createProject"); }
		ProjectsDAO dao = new ProjectsDAO();
		
		// check if present
		Project exist = dao.getProject(name);
		Project project = new Project(name);
		if (exist == null) {
			return dao.addProject(project);
		} else {
			return false;
		}
	}
	
	@Override 
	public CreateProjectResponse handleRequest(CreateProjectRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());

		CreateProjectResponse response;
		try {
			if (createProject(req.name)) {
					response = new CreateProjectResponse(req.name);
			} 
			else {
					response = new CreateProjectResponse(req.name, 400);
			}
			
		} catch (Exception e) {
			response = new CreateProjectResponse("Unable to create constant: " + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}

}
