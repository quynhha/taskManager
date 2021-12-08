package com.amazonaws.lambda.demo;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.ArchiveProjectRequest;
import com.amazonaws.lambda.demo.http.ArchiveProjectResponse;
import com.amazonaws.lambda.demo.http.DeleteProjectRequest;
import com.amazonaws.lambda.demo.http.DeleteProjectResponse;
import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.http.RenameTaskRequest;
import com.amazonaws.lambda.demo.http.RenameTaskResponse;
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