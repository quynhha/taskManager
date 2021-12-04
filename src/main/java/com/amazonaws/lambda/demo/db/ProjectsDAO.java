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

	public Project getProject(String name) throws Exception{
		
		try {
			Project project = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE projectName=?;");
			ps.setString(1,  name);
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
			
			 PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE projectName = ?;");
	            ps.setString(1, project.name);
	            ResultSet resultSet = ps.executeQuery();
	            
	            // already present?
	            while (resultSet.next()) {
	                Project c = generateProject(resultSet);
	                resultSet.close();
	                return false;
	            }
	            
			 // = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE projectName = ?;");
			
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
		String name = resultSet.getString("projectName");
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
	
	public boolean deleteProject(String name) throws Exception {
		try {
			Project project = null;
			PreparedStatement ps = conn.prepareStatement("Delete FROM " + tb1name + " WHERE projectName=?;");
			ps.setString(1,  name);
			int deleteCode = ps.executeUpdate();
			return deleteCode != 0;
			  
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to delete project: " + e.getMessage());
		}
		
		
	}
	
	public void updateNumberOfTasks(String name, int numTasks) throws Exception{
		
		try {
			Project project = null;
			PreparedStatement ps = conn.prepareStatement("Update " + tb1name + "Set numberOfTasks" + numTasks +" WHERE projectName=?;");
			//UPDATE Project SET projectName ='aa' WHERE projectID='2843248';

			ps.setString(1,  name);
			ps.setInt(2,  numTasks);

			ps.executeUpdate();
			  
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to delete project: " + e.getMessage());
		}
		
	}
    
}
