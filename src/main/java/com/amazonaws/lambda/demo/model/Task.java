package com.amazonaws.lambda.demo.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.UUID;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;

public class Task {

	public final String name; 
	public final int id;
	public final String projectName;
	public final int order;
	public int complete;
	
	public Task(String name, String projectName) throws Exception {
		if(name == null) {
			this.name = null;
		}
		else {
		this.name = name;
		}
		Random r = new Random();
		this.id = r.nextInt(10000000);
		this.projectName = projectName;
		
		ProjectsDAO projectdao = new ProjectsDAO();
		
		Project order = projectdao.getProject(projectName);
		this.order = order.numTasks;
		
		projectdao.incrementNumberOfTasks(projectName);
		this.complete = 0;
		
		
		 
		
	}
	
	public Task(String name, int id, String projectName,int order, int complete) {
		this.name = name;
		this.id = id;
		this.projectName = projectName;
		this.order = order;
		this.complete = complete;

	}
	
	public Task() {
		Random r = new Random();

		this.name = r.toString();
		
		this.id = r.nextInt(10000000);
		this.projectName = new Project().name;
		this.order = -2;
		this.complete = 0;

	}
	public void setComplete(int value) {
		this.complete = value;
	}
	
}
