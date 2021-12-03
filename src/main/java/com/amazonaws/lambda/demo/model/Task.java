package com.amazonaws.lambda.demo.model;
import java.util.Random;
import java.util.UUID;

public class Task {

	public final String name; 
	public final int id;
	public final String projectName;
	
	public Task(String name, String projectName) {
		if(name == null) {
			this.name = null;
		}
		else {
		this.name = name;
		}
		Random r = new Random();
		this.id = r.nextInt(10000000);
		this.projectName = projectName;
	}
	
	public Task(String name, int id, String projectName) {
		this.name = name;
		this.id = id;
		this.projectName = projectName;
	}
	
	public Task() {
		Random r = new Random();

		this.name = r.toString();
		
		this.id = r.nextInt(10000000);
		this.projectName = new Project().name;
	}
	
}
