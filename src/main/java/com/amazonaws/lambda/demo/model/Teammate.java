package com.amazonaws.lambda.demo.model;

import java.util.Random;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
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
	//public String nameOfProject;
	
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
	
	public Teammate(String name, String projectName) throws Exception {
		Random r = new Random();
		ProjectsDAO projectsDAO = new ProjectsDAO();
		
//		this.name = name;
		this.projectName = projectsDAO.getProject(projectName);
		this.id = r.nextInt(10000000);
//		this.id = 9099;
		this.name=  name;
		}
	
	public Teammate(String name) {
		Random r = new Random();

		this.name = name;
		
		this.id = r.nextInt(10000000);
	}

}