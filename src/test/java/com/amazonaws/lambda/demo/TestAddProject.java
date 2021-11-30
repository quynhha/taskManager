package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.model.Project;

public class TestAddProject {

	@Test
	public void test() {
		ProjectsDAO  object= new ProjectsDAO();
		Project project = new Project("Project");
		boolean addedObject = false;
		try {
			addedObject  = object.addProject(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(addedObject);
	}
}
