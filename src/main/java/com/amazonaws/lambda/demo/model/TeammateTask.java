package com.amazonaws.lambda.demo.model;

import java.util.Random;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;

public class TeammateTask {
	

	public final String name; 
	public final int id;
	public Project projectName;
	public Task taskName;
	public String teammateName;

	
	/*public TeammateTask(String name, String projectName, String taskName) {
		if(name == null) {
			this.name = null;
			this.projectName = null;
			this.taskName = null;
		}
		else {
		this.name = name;
		this.projectName = projectName;
		this.taskName = taskName;
		}
		Random r = new Random();
		this.id = r.nextInt(10000000);
	}*/
	
	public TeammateTask(String name, int id, Project projectName, Task taskName) {
		this.name = name;
		this.id = id;
		this.projectName = projectName;
		this.taskName = taskName;
	}
	
	public TeammateTask(String name, String projectName, String taskName) throws Exception {
		Random r = new Random();
		ProjectsDAO projectsDAO = new ProjectsDAO();
		TaskDAO taskDAO = new TaskDAO();
		
//		this.name = name;
		this.projectName = projectsDAO.getProject(projectName);
		this.taskName = taskDAO.getTask(taskName, projectName);

		this.id = r.nextInt(10000000);
//		this.id = 9099;
		this.name=  name;
		}
	
	public TeammateTask(String name) {
		Random r = new Random();

		this.name = name;
		
		this.id = r.nextInt(10000000);
	}

}