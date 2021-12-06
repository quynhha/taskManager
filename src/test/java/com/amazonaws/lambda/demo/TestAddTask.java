package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;


import com.amazonaws.lambda.demo.db.TaskDAO;

import com.amazonaws.lambda.demo.model.Task;

public class TestAddTask {

	@Test
	public void testATask() throws Exception {
		TaskDAO  object= new TaskDAO();
		UUID u = UUID.randomUUID();
		//String s = u.toString("task00", "Project");
		Task task = new Task("task00", "Project");
		boolean addedObject = false;
		try {
			addedObject  = object.addTask(task);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(addedObject);
	}
	/*
	@Test
	public void testANonUniqueProject() {
		TaskDAO  object= new TaskDAO();
		UUID u = UUID.randomUUID();
		String s = u.toString();
		Task task = new Task(s);
		Task task2 = new Task(s);
		boolean addedObject = false;
		try {
			 object.addTask(task);
			addedObject  = object.addTask(task2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(!addedObject);
	}
	*/
}
