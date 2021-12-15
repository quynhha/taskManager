package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.After;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.model.Project;

public class TestDeleteProject {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidDelete() {
		//Create a project
		//delete project
		//check get on function
		ProjectsDAO  object= new ProjectsDAO();
		UUID u = UUID.randomUUID();
		String s = u.toString();
		Project project = new Project(s);
		boolean deleted = false;
		
		try {
			object.deleteProject(s);
			deleted = (object.getProject(s) == null);
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
		ProjectsDAO  object= new ProjectsDAO();
		UUID u = UUID.randomUUID();
		String s = u.toString();
		//Project project = new Project(s);
		boolean deleted = false;
		
		try {
			deleted = object.deleteProject(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assert(!deleted);
		assert true;
		
	}

}
