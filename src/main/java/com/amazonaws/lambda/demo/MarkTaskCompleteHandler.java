package com.amazonaws.lambda.demo;


import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteRequest;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class MarkTaskCompleteHandler implements RequestHandler<MarkTaskCompleteRequest, MarkTaskCompleteResponse> {
	public LambdaLogger logger;
	
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;

	public static final String REAL_BUCKET = "projects";

	public static final String TOP_LEVEL_BUCKET = "admins";
	
	
	boolean MarkTaskComplete(String taskName, String projectName) throws Exception{
		logger.log("MarkTaskComplete");
		TaskDAO dao = new TaskDAO();
		
		return dao.MarkTaskComplete(taskName, projectName);

	}
	

	@Override
	public MarkTaskCompleteResponse handleRequest(MarkTaskCompleteRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all constants");

		MarkTaskCompleteResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			boolean markedComplete = MarkTaskComplete(req.taskName, req.projectName);

			
			response = new MarkTaskCompleteResponse(200,"TaskMarkedComplete");
		} catch (Exception e) {
			response = new MarkTaskCompleteResponse(400, e.getMessage());
		}
		
		return response;
	}
}