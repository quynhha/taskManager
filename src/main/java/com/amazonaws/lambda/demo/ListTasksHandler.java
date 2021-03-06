package com.amazonaws.lambda.demo;

import java.util.List;


import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.ListTasksRequest;
import com.amazonaws.lambda.demo.http.ListTasksResponse;
import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class ListTasksHandler implements RequestHandler<ListTasksRequest, ListTasksResponse> {
	public LambdaLogger logger;
	
	
	List<Task> getTask(String projectName) throws Exception{
		logger.log("get all tasks");
		TaskDAO dao = new TaskDAO();
		
		return dao.getAllTasks(projectName);

	}
	
	@Override
	public ListTasksResponse handleRequest(ListTasksRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all constants");

		ListTasksResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			List<Task> list = getTask(req.projectName);
			
			response = new ListTasksResponse(list, 200);
		} catch (Exception e) {
			response = new ListTasksResponse(403, e.getMessage());
		}
		
		return response;
	}
}