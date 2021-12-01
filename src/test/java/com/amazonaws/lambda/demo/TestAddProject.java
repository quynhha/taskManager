package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.model.Project;

public class TestAddProject {

	@Test
	public void testAProject() {
		ProjectsDAO  object= new ProjectsDAO();
		UUID u = UUID.randomUUID();
		String s = u.toString();
		Project project = new Project(s);
		boolean addedObject = false;
		try {
			addedObject  = object.addProject(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(addedObject);
	}
	
	@Test
	public void testANonUniqueProject() {
		ProjectsDAO  object= new ProjectsDAO();
		UUID u = UUID.randomUUID();
		String s = u.toString();
		Project project = new Project(s);
		Project project2 = new Project(s);
		boolean addedObject = false;
		try {
			 object.addProject(project);
			addedObject  = object.addProject(project2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(!addedObject);
	}
}
