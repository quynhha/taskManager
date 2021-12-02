package com.amazonaws.lambda.demo;

import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.http.GetTeammateRequest;
import com.amazonaws.lambda.demo.http.GetTeammateResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Teammate;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;


public class CreateTeammateHandler implements RequestHandler<GetTeammateRequest, GetTeammateResponse> {
	
	LambdaLogger logger;
	
	// To access S3 storage
	@SuppressWarnings("unused")
	private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();
	
	public static final String REAL_BUCKET = "teammate/";
	
	/** Store into RDS.
	 * 
	 * @throws Exception 
	 */
	boolean createTeammate(String name) throws Exception { 
		if (logger != null) { logger.log("in createTeammate"); }
		TeammateDAO dao = new TeammateDAO();
		
		// check if present
		Teammate exist = dao.getTeammate(name);
		Teammate teammate = new Teammate(name);
		if (exist == null) {
			return dao.addTeammate(teammate);
		} else {
			return false;
		}
	}
	
	@Override 
	public GetTeammateResponse handleRequest(GetTeammateRequest req, Context context)  {
		logger = context.getLogger();
		logger.log(req.toString());

		GetTeammateResponse response;
		try {
			
			if (createTeammate(req.name)) {
					response = new GetTeammateResponse(req.name);
			} 
			else {
					response = new GetTeammateResponse(req.name, 400);
			}
			
		} catch (Exception e) {
			response = new GetTeammateResponse("Unable to create teammate: " + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}


    public CreateTeammateHandler() {}

    // Test purpose only.
    CreateTeammateHandler(AmazonS3 s3) {
        this.s3 = s3;
    }

    public String handleRequest(S3Event event, Context context) {
        context.getLogger().log("Received event: " + event);

        // Get the object from the event and show its content type
        String bucket = event.getRecords().get(0).getS3().getBucket().getName();
        String key = event.getRecords().get(0).getS3().getObject().getKey();
        try {
            S3Object response = s3.getObject(new GetObjectRequest(bucket, key));
            String contentType = response.getObjectMetadata().getContentType();
            context.getLogger().log("CONTENT TYPE: " + contentType);
            return contentType;
        } catch (Exception e) {
            e.printStackTrace();
            context.getLogger().log(String.format(
                "Error getting object %s from bucket %s. Make sure they exist and"
                + " your bucket is in the same region as this function.", key, bucket));
            throw e;
        }
    }
}
