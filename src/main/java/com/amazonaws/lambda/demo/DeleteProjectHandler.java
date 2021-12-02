package com.amazonaws.lambda.demo;

import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class DeleteProjectHandler implements RequestHandler<S3Event, String> {

	public LambdaLogger logger;
	
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;

	public static final String REAL_BUCKET = "projects";

	public static final String TOP_LEVEL_BUCKET = "admins";
	
	
	Boolean deleteProject(String name) throws Exception{
		logger.log("Delete Project:" + name);
		ProjectsDAO dao = new ProjectsDAO();
		
		return dao.deleteProject(name);
	}
	
	List<Project> getProjects() throws Exception{
		logger.log("get all Projects");
		ProjectsDAO dao = new ProjectsDAO();
		
		return dao.getAllProjects();
	}
	
	
	
	public deleteProjectResponse handleRequest(GetProjectRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());

		GetProjectResponse response = null;
		List<Project> list;
		Boolean foundDeletedProject = false;
		try {
			 list = getProjects();
			for (Project c : list) {
				if (c.name.equals(req.getName())) {
					System.out.println("Found Project that should have Been Deleted :(");
					foundDeletedProject = true;
				}
			}
			if(foundDeletedProject) {
				response = new deleteProjectResponse(c,list,200, "Successfully got project!");
			}
			
			
		} catch (Exception e) {
			response = new deleteProjectResponse(400, "Project Not Deleted" + req.name + "(" + e.getMessage() + ")");
		}

		return response;
	}



	
}