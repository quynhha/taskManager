package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.lambda.demo.model.TeammateTask;


public class TeammateTaskDAO {
	
	public java.sql.Connection conn;
	String tb1name = "TeammateTask";
	
	public TeammateTaskDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
		
	}

	public int searchForTeammate(String teammateName, String taskName, String projectName) throws Exception {
		  String teammate = null;
		  try {
			  PreparedStatement ps = 
		       conn.prepareStatement("SELECT teammateName FROM sys.TeammateTask where teammateName = '" + teammateName + "'  and taskName = '" + taskName + "' and projectName = '" + projectName + "';");	    
		      ResultSet resultSet = ps.executeQuery();	
		      while (resultSet.next()) {
		        	teammate = resultSet.getString("teammateName");
		      }
		      resultSet.close();
		      ps.close();
	      } catch (Exception e) {
	    	  throw new Exception("Something went wrong: " + e.getMessage());
	      }
	      if (teammate == null) 
	    	  return 0;
	      else
	    	  return 1;
	}
	

	public int addTeammateToTask(String teammateName, String taskName, String projectName) throws Exception{
		try {
			if (searchForTeammate(teammateName, taskName, projectName) == 0) {
				PreparedStatement ps = conn.prepareStatement("Insert into sys.TeammateTask (teammateName, taskName, projectName) values(?, ?, ?);");
	            ps.setString(1,  teammateName); 
	            ps.setString(2, taskName);
	            ps.setString(3, projectName);
	            ps.execute();
	            ps.close();
	         } else {
	        	 return 0;
	         }
			}
		catch (Exception e){
            throw new Exception("Failed to add teammate to task: " + e);
		}
			return searchForTeammate(teammateName, taskName, projectName);
		}
	
	public boolean removeTeammateFromTask(String teammateName, String taskName, String projectName) throws Exception {
		try {
			PreparedStatement ps = 
				conn.prepareStatement("delete from sys.TeammateTask where teammateName = '" + teammateName + "' and taskName = '" + taskName + "' and projectName = '" + projectName + "';");
				ps.execute();
				ps.close();
			return true;
		} catch (Exception ex) {
			throw new Exception("Failed to remove teammate." + ex.getMessage());
		}
	}
	
	private TeammateTask generateTask(ResultSet resultSet) throws Exception {
		String name = resultSet.getString("teammateName");
		String projectName = resultSet.getString("projectName");
		String taskName = resultSet.getString("taskName");
				
		return new TeammateTask(name, projectName, taskName);
		
	}
	
	public int getAllTasks(String teammateName, String projectName) throws Exception {
		// TODO Auto-generated method stub	
			List<TeammateTask> allTasks = new ArrayList<>();
	        try {
	            Statement statement = conn.createStatement();
	            String query = "Select * from TeammateTask where teammateName = '" + teammateName + "' and projectName = '" + projectName + "';";
	            ResultSet resultSet = statement.executeQuery(query);
	            while (resultSet.next()) {
	            		TeammateTask t = generateTask(resultSet);
	            		allTasks.add(t);
	            }
	            resultSet.close();
	            statement.close();

	        } catch (Exception e) {
	            throw new Exception("Failed in getting tasks for teammate: " + e.getMessage());
	        }
	        System.out.println(allTasks.size());
			return allTasks.size();
	    }
	
	public List<TeammateTask> getTeammatesFromProject(String teammateName, String projectName) throws Exception {
		// TODO Auto-generated method stub	
			List<TeammateTask> allTasks = new ArrayList<>();
	        try {
	            Statement statement = conn.createStatement();
	            String query = "Select * from TeammateTask where taskName = '" + teammateName + "' and projectName = '" + projectName + "';";
	            ResultSet resultSet = statement.executeQuery(query);
	            while (resultSet.next()) {
	            		TeammateTask t = generateTask(resultSet);
	            		allTasks.add(t);
	            }
	            resultSet.close();
	            statement.close();

	        } catch (Exception e) {
	            throw new Exception("Failed in getting tasks for teammate: " + e.getMessage());
	        }
			return allTasks;
	    }
	
}