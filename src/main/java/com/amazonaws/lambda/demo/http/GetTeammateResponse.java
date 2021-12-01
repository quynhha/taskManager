package com.amazonaws.lambda.demo.http;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Teammate;

public class GetTeammateResponse {
	public final String response;
	public final int httpCode;
	public final String teammateName;
	//public final List<Teammate> teammateList;
	
	public GetTeammateResponse (String m, int code, String s) {
		this.teammateName = m;
		this.response = s;
		this.httpCode = code;
		//this.teammateList = tm;
	}
	
	public GetTeammateResponse(String s) {
		this.response = "";
		this.httpCode = 0;
		this.teammateName = "";
	}
	
	public GetTeammateResponse(String s, int code) {
		this.response = "";
		this.httpCode = 0;
		this.teammateName = "";
	}
	
	public GetTeammateResponse (AmazonS3 s3) {
		this.response = "";
		this.httpCode = 200;
		//this.teammateList = tm;
		this.teammateName = "";
	}
	// 200 means success
	/*
	public GetTeammateResponse (int code, String errorMessage) {
		this.teammate = new Teammate();
		this.response = "";
		this.httpCode = code;
		this.teammateList = new ArrayList<Teammate>();
	}
	*/
	public String toString() {
		if (teammateName == null) { return "NoTeammateSelected"; }
		return "Teammate" + teammateName + ")";
	}
	
	
	  public String handleRequest(S3Event event, Context context) {
		  return "";
	  }
}

/*
public class GetTeammateResponse implements RequestHandler<S3Event, String> {

    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    public GetTeammateResponse() {}

    // Test purpose only.
    GetTeammateResponse(AmazonS3 s3) {
        this.s3 = s3;
    }

    @Override
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
*/