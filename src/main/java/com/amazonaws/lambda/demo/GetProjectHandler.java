package com.amazonaws.lambda.demo;

import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.http.CreateProjectRequest;
import com.amazonaws.lambda.demo.http.CreateProjectResponse;
import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
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


public class GetProjectHandler implements RequestHandler<GetProjectRequest, GetProjectResponse> {
	public LambdaLogger logger;
	
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;

	public static final String REAL_BUCKET = "projects";

	public static final String TOP_LEVEL_BUCKET = "admins";
	
	
	Project getProject(String name) throws Exception{
		if (logger != null) { logger.log("in loadValue"); }
		ProjectsDAO dao = new ProjectsDAO();
		if (logger != null) { logger.log("retrieved DAO"); }
		Project project = dao.getProject(name);
		if (logger != null) { logger.log("retrieved Constant"); }
		return project;
	}
	
	List<Project> getProjects() throws Exception{
		logger.log("get all Projects");
		ProjectsDAO dao = new ProjectsDAO();
		
		return dao.getAllProjects();
	}
	
	public GetProjectResponse handleRequest(GetProjectRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());

		GetProjectResponse response = null;
		List<Project> list;
		try {
			 list = getProjects();
			 System.out.println(list);
			 System.out.println(req.getName());
			for (Project c : list) {
				System.out.println(c.name);
				if (c.name.equals(req.getName())) {
					response = new GetProjectResponse(c,list,200, "Successfully got project!");
				}
			}
			
		} catch (Exception e) {
			response = new GetProjectResponse(400, "Unable to get Project" + req.name + "(" + e.getMessage() + ")");
		}

		return response;
	}



	
}