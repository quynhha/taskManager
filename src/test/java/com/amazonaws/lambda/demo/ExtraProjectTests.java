package com.amazonaws.lambda.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;

class ExtraProjectTests {

	@Test
	public void testIncrement() throws Exception {
		ProjectsDAO dao = new ProjectsDAO();
		System.out.println(dao.getProject("a").numTasks);
		dao.incrementNumberOfTasks("a");
		System.out.println(dao.getProject("a").numTasks);
		assert(true);
	}
/*
	@Test
	public void testOrderOfProjects() throws Exception{
		TaskDAO dao = new TaskDAO();
		dao.getAllTasks("a");
		assert(true);
	}*/
}
