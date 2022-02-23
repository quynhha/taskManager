package com.amazonaws.lambda.demo;

import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.http.ListProjectsRequest;
import com.amazonaws.lambda.demo.http.ListProjectsResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class ListProjectsHandler implements RequestHandler<Object, ListProjectsResponse> {
	public LambdaLogger logger;
	
	List<Project> getProjects() throws Exception{
		logger.log("get all Projects");
		ProjectsDAO dao = new ProjectsDAO();
		
		return dao.getAllProjects();
	}
	
	@Override
	public ListProjectsResponse handleRequest(Object input, Context context)  {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all constants");

		ListProjectsResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			List<Project> list = getProjects();
			
			response = new ListProjectsResponse(list, 200);
		} catch (Exception e) {
			response = new ListProjectsResponse(403, e.getMessage());
		}
		
		return response;
	}
}