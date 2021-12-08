package com.amazonaws.lambda.demo;




import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteRequest;
import com.amazonaws.lambda.demo.http.MarkTaskCompleteResponse;
import com.amazonaws.lambda.demo.http.MarkTaskIncompleteRequest;
import com.amazonaws.lambda.demo.http.MarkTaskIncompleteResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class MarkTaskIncompleteHandler implements RequestHandler<MarkTaskIncompleteRequest, MarkTaskIncompleteResponse> {
	public LambdaLogger logger;
	
	@SuppressWarnings("unused")
	private AmazonS3 s3 = null;

	public static final String REAL_BUCKET = "projects";

	public static final String TOP_LEVEL_BUCKET = "admins";
	
	
	boolean MarkTaskIncomplete(String taskName, String projectName) throws Exception{
		logger.log("MarkTaskIncomplete");
		TaskDAO dao = new TaskDAO();
		
		return dao.MarkTaskIncomplete(taskName, projectName);

	}
	

	@Override
	public MarkTaskIncompleteResponse handleRequest(MarkTaskIncompleteRequest req, Context context)  {
		logger = context.getLogger();
		logger.log("Marked Task Incomplete");

		MarkTaskIncompleteResponse response;
		try {
			// get all user defined constants AND system-defined constants.
			// Note that user defined constants override system-defined constants.
			boolean markedIncomplete = MarkTaskIncomplete(req.taskName, req.projectName);

			
			response = new MarkTaskIncompleteResponse(200,"TaskMarkedIncomplete");
		} catch (Exception e) {
			response = new MarkTaskIncompleteResponse(400, e.getMessage());
		}
		
		return response;
	}
}