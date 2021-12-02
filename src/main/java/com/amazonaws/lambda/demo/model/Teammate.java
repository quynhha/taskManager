package com.amazonaws.lambda.demo.model;

import java.util.Random;
import java.util.UUID;
/*
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
*/
public class Teammate {
	
	public final String name; 
	public final int id;
	
	public Teammate(String name) {
		if(name == null) {
			this.name = null;
		}
		else {
		this.name = name;
		}
		Random r = new Random();
		this.id = r.nextInt(10000000);
	}
	
	public Teammate(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public Teammate() {
		Random r = new Random();

		this.name = r.toString();
		
		this.id = r.nextInt(10000000);
	}
}
	
	