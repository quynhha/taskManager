package com.amazonaws.lambda.demo.model;
import java.util.Random;
import java.util.UUID;

public class Project {

	public final String name; 
	public final int id;
	public int numTasks;
	public int archived;
	
	public Project(String name) {
		if(name == null) {
			this.name = null;
		}
		else {
		this.name = name;
		}
		Random r = new Random();
		this.id = r.nextInt(10000000);
		numTasks = 0;
	}
	
	public Project(String name, int id) {
		this.name = name;
		this.id = id;
		numTasks = 0;

	}
	
	public Project(String name, int id, int numTasks) {
		this.name = name;
		this.id = id;
		this.numTasks = numTasks;

	}
	
	public int getNumTask() {
		return this.numTasks;
	}
	
	public void setNumTask(int numTasks) {
		this.numTasks = numTasks;
	}
	
	public Project() {
		Random r = new Random();

		this.name = r.toString();
		
		this.id = r.nextInt(10000000);
		numTasks = 0;

	}

	public Project(String name, int id, int numberOfTasks, int status) {
		this.name = name;
		this.id = id;
		this.numTasks = numTasks;
		this.archived = status;
	}
	
}
