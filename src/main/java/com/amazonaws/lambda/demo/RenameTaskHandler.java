package com.amazonaws.lambda.demo;


import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.RenameTaskRequest;
import com.amazonaws.lambda.demo.http.RenameTaskResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;



public class RenameTaskHandler implements RequestHandler<RenameTaskRequest, RenameTaskResponse> {
	public LambdaLogger logger;

	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;

	public static final String REAL_BUCKET = "projects";

	public static final String TOP_LEVEL_BUCKET = "admins";
	
	
	boolean renameTask(String taskName, String projectName, String newName) throws Exception{
		logger.log("renameTask");
		TaskDAO dao = new TaskDAO();
		
		return dao.RenameTask(taskName, projectName, newName);

	}
	
	@Override
	public RenameTaskResponse handleRequest(RenameTaskRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all constants");

		RenameTaskResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			boolean renamed = renameTask(req.taskName, req.projectName, req.newName);

			
			response = new RenameTaskResponse("TaskRenamed");
		} catch (Exception e) {
			response = new RenameTaskResponse(e.getMessage(), 400);
		}
		
		return response;
	}
}