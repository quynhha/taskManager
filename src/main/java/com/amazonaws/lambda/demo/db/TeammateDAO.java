package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeammateDAO {
	
	public java.sql.Connection conn;
	
	public TeammateDAO() {
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
		       conn.prepareStatement("SELECT teammateID FROM sys.Teammate where teammateName = '" + teammateName + "' and projectName = '" + projectName + "';");	    
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
	
	public int addTeammateToProject(String teammateName, String projectName) throws Exception {
		try {
			if (searchForTeammate(teammateName, projectName) == 0) {
				PreparedStatement ps = conn.prepareStatement("Insert into sys.Teammate (teammateName, projectName) values(?, ?);");
	            ps.setString(1,  teammateName); 
	            ps.setString(2, projectName);
	            ps.execute();
	            ps.close();
	         } else {
	        	 return 0;
	         }
			}
		catch (Exception e){
            throw new Exception("Failed to add teammate to project: " + e.getMessage());
		}
			return searchForTeammate(teammateName, projectName);
		}

	public boolean deleteTeammateFromProject(String teammateName, String projectName) throws Exception {
		try {
			PreparedStatement ps = 
				conn.prepareStatement("delete from sys.Teammate where projectName = '" + projectName + "' and teammateName = '" + teammateName + "';");
				ps.execute();
				ps.close();
			return true;
		} catch (Exception ex) {
			throw new Exception("Failed to delete teammate." + ex.getMessage());
		}
	}
}