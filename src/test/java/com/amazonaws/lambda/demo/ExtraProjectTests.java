package com.amazonaws.lambda.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;

class ExtraProjectTests {

	/*@Test
	public void testIncrement() throws Exception {
		ProjectsDAO dao = new ProjectsDAO();
		Project a = dao.getProject("a");
		
		dao.incrementNumberOfTasks("a");
		assert(true);
	}*.
/*
	@Test
	public void testOrderOfProjects() throws Exception{
		TaskDAO dao = new TaskDAO();
		dao.getAllTasks("a");
		assert(true);
	}*/
	
	@Test
	public void createTask() throws Exception{
		TaskDAO dao = new TaskDAO();
		Task newTask = new Task("TestAidTask1", "aid");
		dao.addTask(newTask);
		
		assert(true);
	}
}
