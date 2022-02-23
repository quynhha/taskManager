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
import com.amazonaws.lambda.demo.http.AddTeammateToTaskRequest;
import com.amazonaws.lambda.demo.http.GetTeammateFromTaskRequest;
import com.amazonaws.lambda.demo.http.GetTeammatesFromTaskResponse;
import com.amazonaws.lambda.demo.http.ListTasksForTeammateRequest;
import com.amazonaws.lambda.demo.http.ListTasksForTeammateResponse;
import com.amazonaws.lambda.demo.http.ListTeammatesForTaskRequest;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskRequest;
import com.amazonaws.lambda.demo.http.RemoveTeammateFromTaskResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.lambda.demo.model.TeammateTask;

class ExtraProjectTests2 extends LambdaTest {

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
		
		TaskDAO dao2 = new TaskDAO();
		dao2.RenameTask("RENAMED2", "G4Test3", "RENAMED");
		
		
		
		
		
		//TeammateTaskDAO dao = new TeammateTaskDAO();
		
		//dao.getAllTasks("TestAlice", "G4Test3");
		
		//ListTasksForTeammateHandler handler = new ListTasksForTeammateHandler();
		//ListTasksForTeammateRequest req = new ListTasksForTeammateRequest("TestAlice", "G4Test3" );
		//ListTasksForTeammateResponse r = handler.handleRequest(req, createContext("Test"));
		
		assert(true);
	}
}
