package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.lambda.demo.model.Teammate;

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
	
	
	private Teammate generateTeammate(ResultSet resultSet) throws Exception {
		String name = resultSet.getString("teammateName");
		String projectName = resultSet.getString("projectName");
//		
//		ProjectsDAO projectsDAO = new ProjectsDAO();
//		Project project = projectsDAO.getProject(projectName);
//		
//		
		return new Teammate(name, projectName);
		
	}
	
	public List<Teammate> getAllTeammate(String projectName) throws Exception {
	// TODO Auto-generated method stub	
		List<Teammate> allTeammate = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM sys.Teammate;";//+ "where projectname = "+ projectName + ";";// + "ORDER BY order2;"
            //SELECT * FROM  Task where projectname ="47be12e7-8c88-4120-ad61-f42ba538ca93";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
            		//Teammate t = new Teammate(resultSet.getString("teammateName"), resultSet.getString("projectName"));
            		Teammate t = generateTeammate(resultSet);
            		if(t.projectName.name.equals(projectName)) {
                		System.out.println(t.name);
            			allTeammate.add(t);
            	}
            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            throw new Exception("Failed in getting tasks: " + e.getMessage());
        }
		return allTeammate;
    }

}