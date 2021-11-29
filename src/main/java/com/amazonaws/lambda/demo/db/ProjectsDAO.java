package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.amazonaws.lambda.demo.model.Project;

public class ProjectsDAO {
	
	java.sql.Connection conn;
	
	final String tb1name = "Project";
	
	public ProjectsDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
		
	}

	public Project getProject(String id) throws Exception{
		
		try {
			Project project = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE id=?;");
			ps.setString(1,  id);
			ResultSet resultSet = ps.executeQuery();
			
			  while (resultSet.next()) {
	                project = generateProject(resultSet);
	            }
			resultSet.close();
			ps.close();
			return project;
			  
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting project: " + e.getMessage());
		}
		
	}

	public boolean addProject(Project project) throws Exception {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE name = ?;");
			
			 ps = conn.prepareStatement("INSERT INTO " + tb1name + " (name,id) values(?,?);");
	            ps.setString(1,  project.name); // fix
	            ps.setString(2,  project.id.toString()); 
	            ps.execute();
	            return true;
			}
		catch (Exception e){
            throw new Exception("Failed to insert project: " + e.getMessage());

		}
		}
		

	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Project generateProject(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("name");
		String id = resultSet.getString("projectID");
				
		return new Project(name, UUID.fromString(id));
		
	}

}
