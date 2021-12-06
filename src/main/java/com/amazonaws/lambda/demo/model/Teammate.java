package com.amazonaws.lambda.demo.model;

import java.util.Random;
import java.util.UUID;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class Teammate {
	
	public final String name; 
	public final int id;
	public Project projectName;
	
	public Teammate(String name, Project projectName) {
		if(name == null) {
			this.name = null;
			this.projectName = null;
		}
		else {
		this.name = name;
		this.projectName = projectName;
		}
		Random r = new Random();
		this.id = r.nextInt(10000000);
	}
	
	public Teammate(String name, int id, Project projectName) {
		this.name = name;
		this.id = id;
		this.projectName = projectName;
	}
	
	public Teammate(String name) {
		Random r = new Random();

		this.name = name;
		
		this.id = r.nextInt(10000000);
	}


    private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    // Test purpose only.
    Teammate(AmazonS3 s3) {
        this.s3 = s3;
		this.name = "";
		this.id = 0;
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
