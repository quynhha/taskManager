package com.amazonaws.lambda.demo;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.http.CreateProjectRequest;
import com.amazonaws.lambda.demo.http.CreateProjectResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class CreateTaskHandler implements RequestHandler<CreateTaskRequest, CreateTaskResponse> {

	LambdaLogger logger;
	
	// To access S3 storage
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;
	
	public static final String REAL_BUCKET = "task/";
	
	/** Store into RDS.
	 * 
	 * @throws Exception 
	 */
	boolean createTask(String name) throws Exception { 
		if (logger != null) { logger.log("in createTask"); }
		TaskDAO dao = new TaskDAO();
		
		// check if present
		Task exist = dao.getTask(name);
		Task project = new Task(name);
		if (exist == null) {
			return dao.addTask(task);
		} else {
			return false;
		}
	}
	
	@Override 
	public CreateTaskResponse handleRequest(CreateTaskRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());

		CreateTaskResponse response;
		try {
			if (createProject(req.name)) {
					response = new CreateTaskResponse(req.name);
			} 
			else {
					response = new CreateTaskResponse(req.name, 400);
			}
			
		} catch (Exception e) {
			response = new CreateProjectResponse("Unable to create constant: " + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}

}
