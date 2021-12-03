package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.After;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;

public class TestDeleteTask {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidDelete() {
		//Create a project
		//delete project
		//check get on function
		TaskDAO  object= new TaskDAO();
		UUID u = UUID.randomUUID();
		String s = u.toString();
		Task task = new Task(s);
		boolean deleted = false;
		
		try {
			object.deleteTask(s);
			deleted = (object.getTask(s) == null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assert(deleted);
		
	}
	
	@Test
	public void testInvalidDelete() {
		//Create a project
		//delete project
		//check get on function
		TaskDAO  object= new TaskDAO();
		UUID u = UUID.randomUUID();
		String s = u.toString();
	
		boolean deleted = false;
		
		try {
			deleted = object.deleteTask(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assert(!deleted);
		
	}

}
