package com.amazonaws.lambda.demo.model;
import java.util.Random;
import java.util.UUID;

public class Project {

	public final String name; 
	public final int id;
	
	public Project(String name) {
		if(name == null) {
			this.name = "NoName";
		}
		else {
		this.name = name;
		}
		Random r = new Random();
		this.id = r.nextInt(10000000);
	}
	
	public Project(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
}
