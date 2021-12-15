package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.ListProjectsResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;

public class TestGetTask {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTaskInvalidName() {
		TaskDAO  object= new TaskDAO();
		boolean addedObject = false;
		Task task = null;
		try {
			task  = object.getTask("a", "asdfsdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(task == null);
	}

	@Test
	public void testGetTaskValidname() {
		TaskDAO  object= new TaskDAO();
		boolean addedObject = false;
		Task task = null;
		try {
			task  = object.getTask("a", "Task 2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(task != null);
	}

}
