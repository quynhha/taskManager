package com.amazonaws.lambda.demo;


import java.util.List;

import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.GetTeammateFromTaskRequest;
import com.amazonaws.lambda.demo.http.GetTeammatesFromTaskResponse;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteRequest;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteResponse;
import com.amazonaws.lambda.demo.model.Teammate;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class GetTeammatesFromTaskHandler implements RequestHandler<GetTeammateFromTaskRequest, GetTeammatesFromTaskResponse> {
	public LambdaLogger logger;
	
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;

	public static final String REAL_BUCKET = "projects";

	public static final String TOP_LEVEL_BUCKET = "admins";
	
	
	List<Teammate> MarkTaskComplete(String taskName, String projectName) throws Exception{
		logger.log("MarkTaskComplete");
		TeammateTaskDAO dao = new TeammateTaskDAO();
		
		return dao.getTeammatesFromTask(projectName, taskName);

	}
	

	@Override
	public GetTeammatesFromTaskResponse handleRequest(GetTeammateFromTaskRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Get Teammates From Task Complete");

		GetTeammatesFromTaskResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			List<Teammate> markedComplete = MarkTaskComplete(req.taskName, req.projectName);

			
			response = new GetTeammatesFromTaskResponse(markedComplete,200);
		} catch (Exception e) {
			response = new GetTeammatesFromTaskResponse(400, e.getMessage());
		}
		
		return response;
	}
}