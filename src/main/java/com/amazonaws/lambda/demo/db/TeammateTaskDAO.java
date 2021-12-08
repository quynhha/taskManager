package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		  int teammateID = 0;
		  try {
			  PreparedStatement ps = 
		       conn.prepareStatement("SELECT teammateName FROM sys.TeammateTask where teammateName = '" + teammateName + "'  and taskName = '\" + taskName + \"' and projectName = '\" + projectName + \"';");	    
		      ResultSet resultSet = ps.executeQuery();	
		      while (resultSet.next()) {
		        	teammateID = resultSet.getInt("teammateID");
		      }
		      resultSet.close();
		      ps.close();
	      } catch (Exception e) {
	    	  throw new Exception("Something went wrong: " + e.getMessage());
	      }
	      return teammateID;
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
            throw new Exception("Failed to add teammate to task: " + e.getMessage());
		}
			return searchForTeammate(teammateName, taskName, projectName);
		}
	
	public boolean removeTeammateFromTask(String teammateName, String taskName, String projectName) throws Exception {
		try {
			PreparedStatement ps = 
				conn.prepareStatement("delete from sys.TeammateTask where taskName = '" + taskName + "' and teammateName = '" + teammateName + "';");
				ps.execute();
				ps.close();
			return true;
		} catch (Exception ex) {
			throw new Exception("Failed to remove teammate." + ex.getMessage());
		}
	}
	
	public boolean getTasksByTeammate(String teammateName, String projectName) throws Exception {
		PreparedStatement ps = conn.prepareStatement("Select * from " + tb1name + " where teammateName = ? and projectName = ?;");
        Statement statement = conn.createStatement(); 
		ps.setString(1,  teammateName); // fix
         ps.setString(2, projectName);
         ps.executeQuery();
         ResultSet resultSet = statement.executeQuery(query);


         while (resultSet.next()) {
         		Task t = generateTask(resultSet);
         		if(t.projectName.contentEquals(projectName)) {
             		System.out.println(t.name);
         			allTasks.add(t);
         	}
         }
         resultSet.close();
         statement.close();

	}
}