package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.http.DeleteProjectRequest;
import com.amazonaws.lambda.demo.http.DeleteProjectResponse;
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

public class DeleteProjectHandler implements RequestHandler<DeleteProjectRequest, DeleteProjectResponse> {

	public LambdaLogger logger;
	
	
	boolean deleteProject(String name) throws Exception{
		boolean deleted = false;
		if(logger != null ) {
			logger.log("Delete a project ... ");
		}
		
		ProjectsDAO dao = new ProjectsDAO();
		
		deleted = dao.deleteProject(name);
		System.out.println("Deleted:" + deleted);
		return deleted;
	}
	
	
	
	public DeleteProjectResponse handleRequest(DeleteProjectRequest req, Context context){
		logger = context.getLogger();
		logger.log(req.toString());

		DeleteProjectResponse response = null;

		try {
			 if(deleteProject(req.name)) {
				 response = new DeleteProjectResponse(req.name);
				 
			 }
			 else {
				 response = new DeleteProjectResponse( req.name, 400);
			 }
			
			
		} catch (Exception e) {
			response = new DeleteProjectResponse( "Project Not Deleted" + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}
	

	
}