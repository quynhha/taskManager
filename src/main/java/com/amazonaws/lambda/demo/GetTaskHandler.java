package com.amazonaws.lambda.demo;

import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.CreateProjectRequest;
import com.amazonaws.lambda.demo.http.CreateProjectResponse;
import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.http.GetTaskRequest;
import com.amazonaws.lambda.demo.http.GetTaskResponse;
import com.amazonaws.lambda.demo.http.ListProjectsRequest;
import com.amazonaws.lambda.demo.http.ListProjectsResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;


public class GetTaskHandler implements RequestHandler<GetTaskRequest, GetTaskResponse> {
	public LambdaLogger logger;
	
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;

	public static final String REAL_BUCKET = "projects";

	public static final String TOP_LEVEL_BUCKET = "admins";
	
	
	Task getTask(String name) throws Exception{
		if (logger != null) { logger.log("in loadValue"); }
		TaskDAO dao = new TaskDAO();
		if (logger != null) { logger.log("retrieved DAO"); }
		Task task = dao.getTask(name);
		if (logger != null) { logger.log("retrieved Constant"); }
		return task;
	}
	
	List<Task> getTasks() throws Exception{
		logger.log("get all Projects");
		TaskDAO dao = new TaskDAO();
		
		return dao.getAllTasks(null));
	}
	
	public GetTaskResponse handleRequest(GetTaskRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());

		GetTaskResponse response = null;
		List<Task> list;
		try {
			 list = getTasks();
			 System.out.println(list);
			 System.out.println(req.getName());
			for (Task c : list) {
				System.out.println(c.name);
				if (c.name.equals(req.getName())) {
					response = new GetTaskResponse(c,list,200, "Successfully got tasks!");
				}
			}
			
		} catch (Exception e) {
			response = new GetTaskResponse(400, "Unable to get Tasks" + req.name + "(" + e.getMessage() + ")");
		}

		return response;
	}



	
}