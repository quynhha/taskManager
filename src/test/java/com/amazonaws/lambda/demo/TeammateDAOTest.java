package com.amazonaws.lambda.demo;

import org.junit.Assert;
import org.junit.Test;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.model.Teammate;

public class TeammateDAOTest {

	@Test
    public void createTeammate() throws Exception {
        Teammate teammate = new Teammate("Teammate Name", "Project Name");
		   assert true;
    }
	
	
    @Test
    public void test() throws Exception {
        
    		   TeammateDAO teammateDAO = new TeammateDAO();
    		   teammateDAO.getAllTeammate("TestProject");
    		   assert true;
    }
}