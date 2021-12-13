package com.amazonaws.lambda.demo;


import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.ArchiveProjectRequest;
import com.amazonaws.lambda.demo.http.ArchiveProjectResponse;
import com.amazonaws.lambda.demo.http.GetPercentageCompleteRequest;
import com.amazonaws.lambda.demo.http.GetPercentageCompleteResponse;
import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.http.ListTasksRequest;
import com.amazonaws.lambda.demo.http.ListTasksResponse;
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

public class GetPercentageCompleteHandler implements RequestHandler<GetPercentageCompleteRequest, GetPercentageCompleteResponse> {
	public LambdaLogger logger;
	
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;

	public static final String REAL_BUCKET = "projects";

	public static final String TOP_LEVEL_BUCKET = "admins";
	
	
	int GetPercentageComplete(String projectName) throws Exception{
		if (logger != null) { logger.log("in loadValue"); }
		ProjectsDAO dao = new ProjectsDAO();
		if (logger != null) { logger.log("retrieved DAO"); }
		int percentageComplete= dao.getPercentageComplete(projectName);
		if (logger != null) { logger.log("retrieved Constant"); }
		return percentageComplete;
	}
	
	
	@Override
	public GetPercentageCompleteResponse handleRequest(GetPercentageCompleteRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all constants");

		GetPercentageCompleteResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			@SuppressWarnings("unused")
			int percentageComplete = GetPercentageComplete(req.projectName);

			
<<<<<<< Updated upstream
			response = new GetPercentageCompleteResponse(200, null, percentageComplete);
=======
			response = new GetPercentageCompleteResponse(200);
>>>>>>> Stashed changes
		} catch (Exception e) {
			response = new GetPercentageCompleteResponse(400, e.getMessage(), 0);
		}
		
		return response;
	}


	public int PercentageComplete(Object projectName) {
		// TODO Auto-generated method stub
		return 0;
	}	
}