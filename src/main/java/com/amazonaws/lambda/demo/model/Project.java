package com.amazonaws.lambda.demo.model;

import java.util.UUID;

public class Project {

	public final String name; 
	public final UUID id;
	
	public Project(String name) {
		this.name = name;
		this.id = UUID.randomUUID();
	}
	
	public Project(String name, UUID id) {
		this.name = name;
		this.id = id;
	}
	
}
