package com.amazonaws.lambda.demo;

import java.util.List;

import org.junit.Test;

import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.model.Task;

public class TestAddTask {

	@Test
<<<<<<< Updated upstream
	public void testATask() throws Exception {
		TaskDAO taskdao = new TaskDAO();
		//TaskDAO  object= new TaskDAO();
		Task task = new Task("Task03", "47be12e7-8c88-4120-ad61-f42ba538ca93");
		taskdao.addTask(task);
		assert(true);
=======
	public void testATask() {
		TaskDAO  object= new TaskDAO();
		UUID u = UUID.randomUUID();
		String s = u.toString();
		Task task = new Task();
		boolean addedObject = false;
		try {
			addedObject  = object.addTask(task);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(addedObject);
>>>>>>> Stashed changes
	}
	
	@Test
	public void testListTask() throws Exception {
		TaskDAO taskdao = new TaskDAO();
		//TaskDAO  object= new TaskDAO();
		List<Task> tasks = taskdao.getAllTasks("47be12e7-8c88-4120-ad61-f42ba538ca93");
		assert(true);
	}
	
	
	//@Test
	public void testANonUniqueProject() {
		/*TaskDAO  object= new TaskDAO();
		UUID u = UUID.randomUUID();
		String s = u.toString();
		Task task = new Task();
		Task task2 = new Task();
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
