package com.amazonaws.lambda.demo;

import java.util.List;


import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.ListTasksForTeammateRequest;
import com.amazonaws.lambda.demo.http.ListTasksForTeammateResponse;
import com.amazonaws.lambda.demo.model.TeammateTask;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ListTasksForTeammateHandler implements RequestHandler<ListTasksForTeammateRequest, ListTasksForTeammateResponse> {
	
	public LambdaLogger logger;
	
	List<TeammateTask> getTask(String teammateName) throws Exception{
		logger.log("get all tasks fro teammate");
		TeammateTaskDAO dao = new TeammateTaskDAO();
		
		return dao.getAllTasks(teammateName);

	}
	
	@Override
	public ListTasksForTeammateResponse handleRequest(ListTasksForTeammateRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Loading Java Lambda handler to list all constants");

		ListTasksForTeammateResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			List<TeammateTask> list = getTask(req.teammateName);
			
			response = new ListTasksForTeammateResponse(list, 200);
		} catch (Exception e) {
			response = new ListTasksForTeammateResponse(400, e.getMessage());
		}
		
		return response;
	}
}