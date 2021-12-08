package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.model.Task;

import org.junit.Assert;
public class RenameTaskTest {

	@Test
	public void test() {
		try {
			UUID uid = UUID.randomUUID();
			String name = uid.toString().substring(0, 15);
			
			TaskDAO dao = new TaskDAO();
			Task c = new Task(name, 20, "project1");
			Assert.assertTrue(dao.addTask(c));
			
			// validate can get constant back
			Task c2 = dao.getTask(name);
			Assert.assertTrue(c2 != null);
			
			Task c3 = new Task(name, 20, "project1");
			dao.RenameTask(c3);
			
			Task c4 = dao.getTask(name);
			Assert.assertTrue(c4 != null);
			Assert.assertTrue(20 == c4.id);
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
			fail ("Error:" + e.getMessage());
		}
		
	}
	
	@Test
	public void testFailToUpdate() {
		try {
			UUID uid = UUID.randomUUID();
			String name = uid.toString().substring(0, 15);
			
			TaskDAO dao = new TaskDAO();
			
			Task c3 = new Task(name, 20,"project1" );
			Assert.assertFalse(dao.RenameTask(c3));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail ("Error:" + e.getMessage());
		}
		
	}

}
