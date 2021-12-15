package com.amazonaws.lambda.demo;

import java.util.List;


import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.http.ListTasksRequest;
import com.amazonaws.lambda.demo.http.ListTasksResponse;
import com.amazonaws.lambda.demo.http.ListTeammatesRequest;
import com.amazonaws.lambda.demo.http.ListTeammatesResponse;
import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.lambda.demo.model.Teammate;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class ListTeammateHandler implements RequestHandler<ListTeammatesRequest, ListTeammatesResponse> {
	public LambdaLogger logger;
	
	
	List<Teammate> getTeammate(String projectName) throws Exception{
		logger.log("get all teammates");
		TeammateDAO dao = new TeammateDAO();
		
		return dao.getAllTeammate(projectName);

	}
	
	@Override
	public ListTeammatesResponse handleRequest(ListTeammatesRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all constants");

		ListTeammatesResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			List<Teammate> list = getTeammate(req.projectName);
			
			response = new ListTeammatesResponse(list, 200);
		} catch (Exception e) {
			response = new ListTeammatesResponse(403, e.getMessage());
		}
		
		return response;
	}
}