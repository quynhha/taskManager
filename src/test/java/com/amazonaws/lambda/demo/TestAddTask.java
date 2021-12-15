package com.amazonaws.lambda.demo;

import java.util.List;

import org.junit.Test;

import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.model.Task;

public class TestAddTask {

	@Test
	public void testATask() throws Exception {
		TaskDAO taskdao = new TaskDAO();
		//TaskDAO  object= new TaskDAO();
		Task task = new Task(taskdao.toString(), "a");
		taskdao.addTask(task);
		assert(true);}
	
	
	@Test
	public void testListTask() throws Exception {
		TaskDAO taskdao = new TaskDAO();
		//TaskDAO  object= new TaskDAO();
		List<Task> tasks = taskdao.getAllTasks("47be12e7-8c88-4120-ad61-f42ba538ca93");
		assert(true);
	}
	

}
