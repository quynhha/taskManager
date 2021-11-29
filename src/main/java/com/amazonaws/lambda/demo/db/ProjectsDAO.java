package com.amazonaws.lambda.demo.db;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Project;

import edu.wpi.cs.heineman.demo.model.Constant;

public class ProjectsDAO {

	public Project getProject(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addProject(Project project) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Project> getAllProjects() throws Exception {
		// TODO Auto-generated method stub
		//return null;
		
		List<Project> allProjects = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM " + tblName + ";";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Project p = generateProject(resultSet);
                allProjects.add(p);
            }
            resultSet.close();
            statement.close();
            return allProjects;

        } catch (Exception e) {
            throw new Exception("Failed in getting projects: " + e.getMessage());
        }
    }
    
    private Project generateProject(ResultSet resultSet) throws Exception {
        String id  = resultSet.getString("id");
        return new Project (id);
    }

}
