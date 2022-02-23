package com.amazonaws.lambda.demo;


import java.util.List;

import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.ListTeammatesForTaskRequest;
import com.amazonaws.lambda.demo.http.ListTeammatesForTaskResponse;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteRequest;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteResponse;
import com.amazonaws.lambda.demo.model.Teammate;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class ListTeammatesForTaskHandler implements RequestHandler<ListTeammatesForTaskRequest, ListTeammatesForTaskResponse> {
	public LambdaLogger logger;
	
	
	List<Teammate> ListTeammatesForTask(String projectName,String taskName) throws Exception{
		logger.log("ListTeammatesForTask, Task:  " + taskName + ", Project:" );
		TeammateTaskDAO dao = new TeammateTaskDAO();
		
		return dao.getTeammatesFromTask(projectName, taskName);

	}
	

	@Override
	public ListTeammatesForTaskResponse handleRequest(ListTeammatesForTaskRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Marked Task Complete");

		ListTeammatesForTaskResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			List<Teammate> teammatesListed = ListTeammatesForTask(req.taskName, req.projectName);

			
			response = new ListTeammatesForTaskResponse(200,"TaskMarkedComplete");
		} catch (Exception e) {
			response = new ListTeammatesForTaskResponse(400, e.getMessage());
		}
		
		return response;
	}
}