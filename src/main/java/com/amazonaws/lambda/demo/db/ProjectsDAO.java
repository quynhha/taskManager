package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE projectID=?;");
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
			PreparedStatement ps;// = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE projectName = ?;");
			
			 ps = conn.prepareStatement("INSERT INTO " + tb1name + " (projectName, projectID) values(?,?);");
	            ps.setString(1,  project.name); // fix
	            ps.setInt(2,  project.id); 
	            System.out.println();
	            ps.execute();
	            return true;
			}
		catch (Exception e){
            throw new Exception("Failed to insert project: " + e.getMessage());

			}
		}
		

	
	private Project generateProject(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("name");
		int id = resultSet.getInt("projectID");
				
		return new Project(name, id);
		
	}

	public List<Project> getAllProjects() throws Exception {
	// TODO Auto-generated method stub	
		List<Project> allProjects = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM " + tb1name + ";";
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
    
}
