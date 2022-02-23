package com.amazonaws.lambda.demo;

import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.ArchiveProjectRequest;
import com.amazonaws.lambda.demo.http.ArchiveProjectResponse;
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

public class ArchiveProjectHandler implements RequestHandler<ArchiveProjectRequest, ArchiveProjectResponse> {
	public LambdaLogger logger;
	
	boolean archiveProject(String projectName) throws Exception{
		logger.log("archiveProject");
		ProjectsDAO dao = new ProjectsDAO();
		
		return dao.archiveProject(projectName);

	}
	
	@Override
	public ArchiveProjectResponse handleRequest(ArchiveProjectRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all constants");

		ArchiveProjectResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			boolean archived = archiveProject(req.projectName);

			
			response = new ArchiveProjectResponse(200);
		} catch (Exception e) {
			response = new ArchiveProjectResponse(400, e.getMessage());
		}
		
		return response;
	}
}