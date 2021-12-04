package com.amazonaws.lambda.demo.model;
import java.util.Random;
import java.util.UUID;

import com.amazonaws.lambda.demo.db.ProjectsDAO;

public class Task {

	public final String name; 
	public final int id;
	public final String projectName;
	public final int taskNumber;
	
	public Task(String name, String projectName) throws Exception {
		if(name == null) {
			this.name = null;
		}
		else {
		this.name = name;
		}
		Random r = new Random();
		
		ProjectsDAO dao = new ProjectsDAO();
		
		this.taskNumber = dao.getProject(projectName).numberOfTasks;
		dao.updateNumberOfTasks(projectName, this.taskNumber + 1);
		
		this.projectName = projectName;
		this.id = r.nextInt(10000000);
	}
	
	/*public Task(String name, int taskNumber, String projectName, int id) {
		this.name = name;
		this.taskNumber = taskNumber;
		this.projectName = projectName;
		this.id = id;
	}*/
	
	public Task() {
		Random r = new Random();

		this.name = r.toString();
		
		this.id = r.nextInt(10000);
		this.projectName = new Project().name;
		this.taskNumber = r.nextInt(10000000);
	}
	
}
