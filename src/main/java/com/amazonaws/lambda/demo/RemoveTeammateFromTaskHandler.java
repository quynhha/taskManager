package com.amazonaws.lambda.demo;

import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskRequest;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class RemoveTeammateFromTaskHandler implements RequestHandler<RemoveTeammateFromTaskRequest, RemoveTeammateFromTaskResponse> {

		LambdaLogger logger;

		boolean removeTeammateFromTask(String teammateName, String projectName,String taskName) throws Exception { 
			if (logger != null) { logger.log(" in removeTeammateFromTask"); }
			TeammateTaskDAO dao = new TeammateTaskDAO();
			
			// check if present
			if (dao.removeTeammateFromTask(teammateName,  projectName, taskName) == false) {
				return false;
			} else {
				return true;
			}
		}
		
		@Override 
		public RemoveTeammateFromTaskResponse handleRequest(RemoveTeammateFromTaskRequest req, Context context)  {
			logger = context.getLogger();
			logger.log(req.toString());
	        
			RemoveTeammateFromTaskResponse response;
			try {
<<<<<<< Updated upstream
				if (removeTeammateFromTask(req.name, req.task, req.project)) {
						response = new RemoveTeammateFromTaskResponse(req.name, 200);
=======
				if (removeTeammateFromTask(req.getName(), req.getProject(),  req.getTask())) {
						response = new RemoveTeammateFromTaskResponse(req.getName(), 200);
>>>>>>> Stashed changes
				} 
				else {
						response = new RemoveTeammateFromTaskResponse(req.name, 400);
				}
				
			} catch (Exception e) {
				response = new RemoveTeammateFromTaskResponse("Unable to remove teammate from task: " + req.name + "(" + e.getMessage() + ")", 400);
			}

			return response;
		}
}