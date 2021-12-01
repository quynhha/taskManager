package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.UUID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.http.ListProjectsResponse;
import com.amazonaws.lambda.demo.model.Project;

public class TestGetProject {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetProjectInvalidName() {
		ProjectsDAO  object= new ProjectsDAO();
		boolean addedObject = false;
		Project project = null;
		try {
			project  = object.getProject("ldsajflkds");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(project == null);
	}

	@Test
	public void testGetProjectValidname() {
		ProjectsDAO  object= new ProjectsDAO();
		boolean addedObject = false;
		Project project = null;
		try {
			project  = object.getProject("a");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	assert(project != null);
	}

}
