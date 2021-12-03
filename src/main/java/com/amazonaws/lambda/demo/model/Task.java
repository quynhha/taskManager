package com.amazonaws.lambda.demo.model;
import java.util.Random;
import java.util.UUID;

public class Task {

	public final String name; 
	public final int id;
	public final int projectID;
	
	public Task(String name, int projectID) {
		if(name == null) {
			this.name = null;
		}
		else {
		this.name = name;
		}
		Random r = new Random();
		this.id = r.nextInt(10000000);
		this.projectID = projectID;
	}
	
	public Task(String name, int id, int projectID) {
		this.name = name;
		this.id = id;
		this.projectID = projectID;
	}
	
	public Task() {
		Random r = new Random();

		this.name = r.toString();
		
		this.id = r.nextInt(10000000);
		this.projectID = new Project().id;
	}
	
}
