package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.amazonaws.lambda.demo.model.TeammateTask;


public class TeammateTaskDAO {
	
	public java.sql.Connection conn;
	
	public TeammateTaskDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
		
	}

	public int searchForTeammate(String teammateName, String projectName) throws Exception {
		  int teammateID = 0;
		  try {
			  PreparedStatement ps = 
		       conn.prepareStatement("SELECT teammateID FROM sys.TeammateTask where teammateName = '" + teammateName + "' and projectName = '" + projectName + "';");	    
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
	

	public int addTeammateToTask(String teammateName, String taskName) throws Exception{
		try {
			if (searchForTeammate(teammateName, taskName) == 0) {
				PreparedStatement ps = conn.prepareStatement("Insert into sys.TeammateTask (teammateName, taskName) values(?, ?);");
	            ps.setString(1,  teammateName); 
	            ps.setString(2, taskName);
	            ps.execute();
	            ps.close();
	         } else {
	        	 return 0;
	         }
			}
		catch (Exception e){
            throw new Exception("Failed to add teammate to task: " + e.getMessage());
		}
			return searchForTeammate(teammateName, taskName);
		}
	
	public boolean removeTeammateFromTask(String teammateName, String taskName) throws Exception {
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
}