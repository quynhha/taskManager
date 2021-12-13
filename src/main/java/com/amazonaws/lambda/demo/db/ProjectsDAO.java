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
			List<Project> ProjectList1 = getAllProjects();
			for(Project p : ProjectList1) {
				if(p.name.equals(name)) {
					return p;
				}
			}
			return null;
			  
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
		int numberOfTasks = resultSet.getInt("numberOfTasks");
		int numberOfCompleteTasks = resultSet.getInt("Complete");
		int percentageComplete = resultSet.getInt("percentageComplete");
		int status = resultSet.getInt("status");
		
		
		return new Project(name, id, numberOfTasks,numberOfCompleteTasks,percentageComplete, status);
		
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
			PreparedStatement ps = conn.prepareStatement("Delete FROM " + tb1name + " WHERE projectName = ?;");
			ps.setString(1,  name);
			int deleteCode = ps.executeUpdate();
			System.out.println(deleteCode);
			if (deleteCode == 0)
					return true;
			else
					return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to delete project: " + e.getMessage());
		}
		
		
	}
	
	public int getNumberOfTasks(String projectName) throws Exception {
		try {
				Project p = getProject(projectName);
				System.out.println(p.name);
				System.out.println(p.getNumTask());

				return p.getNumTask();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to delete project: " + e.getMessage());
		}
		
	}
	
	public void incrementNumberOfTasks(String projectName) throws Exception{
		//int currentNumTasks = this.getProject(projectName).numTasks ++;
		//System.out.println("Tasks from local object:" + currentNumTasks );
		//currentNumTasks++;
		
		
		int newNumOfTasks = this.getNumberOfTasks(projectName);
		//System.out.println(newNumOfTasks);
		newNumOfTasks++;
		//System.out.println(newNumOfTasks);

		Project p = getProject(projectName);
		p.setNumTask(newNumOfTasks);
		System.out.println(p.getNumTask());

		
		PreparedStatement ps = conn.prepareStatement("Update " + tb1name + " Set numberOfTasks = ? WHERE projectName = ?;");
		//PreparedStatement ps = conn.prepareStatement("update Project Set numberOfTasks = 0 where projectName = Project2 ;");
		ps.setInt(1,  newNumOfTasks);
		ps.setString(2, projectName);
		
		int num = ps.executeUpdate();
		ps.close();
	}
	
	public boolean archiveProject(String projectName) throws Exception{
		
		if(this.getProject(projectName) == null) {
			return false;
		}
		Project p = getProject(projectName);
		PreparedStatement ps = conn.prepareStatement("Update " + tb1name + " Set status = 1 WHERE projectName = ?;");
		ps.setString(1,  projectName);
		
		int num = ps.executeUpdate();
		ps.close();
		return true;
	}
	public void incrementNumberOfCompleteTasks(String projectName) throws Exception{
		
		
		int newNumOfCompleteTasks = this.getNumberOfCompleteTasks(projectName);
		//System.out.println(newNumOfTasks);
		newNumOfCompleteTasks++;
		//System.out.println(newNumOfTasks);

		Project p = getProject(projectName);
		p.setNumCompleteTask(newNumOfCompleteTasks);
		System.out.println(p.getNumCompleteTask());

		
		PreparedStatement ps = conn.prepareStatement("Update " + tb1name + " Set numberOfCompleteTasks = ? WHERE projectName = ?;");
		//PreparedStatement ps = conn.prepareStatement("update Project Set numberOfTasks = 0 where projectName = Project2 ;");
		ps.setInt(1,  newNumOfCompleteTasks);
		ps.setString(2, projectName);
		
		int num = ps.executeUpdate();
		ps.close();
	}
	public int getNumberOfCompleteTasks(String projectName) throws Exception {
		try {
				Project p = getProject(projectName);
				System.out.println(p.name);
				System.out.println(p.getNumCompleteTask());

				return p.getNumCompleteTask();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to delete project: " + e.getMessage());
		}
		
	}
public void PercentageComplete(String projectName) throws Exception{
		
		
		int PercentageComplete = this.getPercentageComplete(projectName);
		//System.out.println(newNumOfTasks);
//		newNumOfCompleteTasks++;
		//System.out.println(newNumOfTasks);

		Project p = getProject(projectName);
		p.setPercentageComplete(PercentageComplete);
		System.out.println(p.getPercentageComplete());

		
		PreparedStatement ps = conn.prepareStatement("Update " + tb1name + " Set percentageComplete = (numberOfCompleteTasks / numberOfTasks)*100 ? WHERE projectName = ?;");
		//PreparedStatement ps = conn.prepareStatement("update Project Set numberOfTasks = 0 where projectName = Project2 ;");
		ps.setInt(1,  PercentageComplete);
		ps.setString(2, projectName);
		
		int num = ps.executeUpdate();
		ps.close();
	}

public int getPercentageComplete(String projectName) {
	// TODO Auto-generated method stub
	return 0;
}




}
