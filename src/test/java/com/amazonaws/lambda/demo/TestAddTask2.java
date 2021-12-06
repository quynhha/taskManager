package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.model.Task;

public class TestAddTask2 {

	@Test
	public void testATask() throws Exception {
		TaskDAO taskdao = new TaskDAO();
		//TaskDAO  object= new TaskDAO();
		Task task = new Task("Task00", "Project");
		taskdao.addTask(task);
		assert(false);
	}
	
	//@Test
	public void testANonUniqueProject() {
		/*TaskDAO  object= new TaskDAO();
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
	
	assert(!addedObject);*/
	}
}
