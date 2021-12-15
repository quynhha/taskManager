package com.amazonaws.lambda.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.db.TeammateTaskDAO;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.lambda.demo.model.TeammateTask;

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
		TeammateTaskDAO dao = new TeammateTaskDAO();
		dao.getTeammatesFromTask("a", "Task 2");
		//TeammateDAO tdao = new TeammateDAO();
		//tdao.getAllTeammate("a");
		
		assert(true);
	}
}
