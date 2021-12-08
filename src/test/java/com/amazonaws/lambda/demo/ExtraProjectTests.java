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
	}
	
	@Test
	public void createTask() throws Exception{
		TaskDAO dao = new TaskDAO();
		Task newTask = new Task("TestAidTask4", "aid");
		dao.addTask(newTask);
		
		assert(true);
	}*/
	

	@Test
	public void testArchiveProject() throws Exception{
		ProjectsDAO dao = new ProjectsDAO();
		dao.archiveProject("2228ae6d-8f8b-4fff-a435-f54cbeb1efe3");
		System.out.println(dao.getProject("2228ae6d-8f8b-4fff-a435-f54cbeb1efe3").archived);
		assert(true);
	}
}
