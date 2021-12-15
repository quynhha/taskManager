package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.lambda.demo.model.Teammate;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import com.amazonaws.lambda.demo.model.TeammateTask;
=======

>>>>>>> Stashed changes
=======

>>>>>>> Stashed changes
import com.amazonaws.lambda.demo.RemoveTeammateFromTaskHandler;
import com.amazonaws.lambda.demo.ListTasksHandler;
//import com.amazonaws.lambda.demo.utils.DatabaseUtil;


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
				
				TaskDAO taskdao = new TaskDAO();
				ProjectsDAO projectdao = new ProjectsDAO();

				TeammateTaskDAO teammatetaskdao = new TeammateTaskDAO();

				//Create list with teammateName and projectName
				//List<Task> taskList = taskdao.getAllTasks(projectName);
				List<TeammateTask> teammateTaskList = teammatetaskdao.listTeammateTasks(teammateName, projectName); 
				
				//for(Task t : taskList) {
					//String taskName = t.name;
					for(TeammateTask tmtsk : teammateTaskList) {
						
						Project project = projectdao.getProject(projectName);
						Task task = taskdao.getTask(tmtsk.taskName.name, tmtsk.projectName.name);
						teammatetaskdao.removeTeammateFromTask(tmtsk.name, tmtsk.taskName.name, tmtsk.projectName.name);
				//	}
				}
				
				//For each in list
				//remove from project
				
				
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
            //String query = "SELECT * FROM sys.Teammate where projectName = ?;";//+ "where projectname = "+ projectName + ";";// + "ORDER BY order2;"
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Teammate where projectName =?;");
            ps.setString(1, projectName);
            
            
            //SELECT * FROM  Task where projectname ="47be12e7-8c88-4120-ad61-f42ba538ca93";
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
            		//Teammate t = new Teammate(resultSet.getString("teammateName"), resultSet.getString("projectName"));
            		Teammate t = generateTeammate(resultSet);
            		//System.out.println(t.projectName.name);
            		if(t.projectName.name.equals(projectName)) {
                		//System.out.println(t.name);
            			allTeammate.add(t);
            	}
            }
            for(Teammate t: allTeammate) {
            	//System.out.println(t.name);
            }
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            throw new Exception("Failed in getting tasks: " + e.getMessage());
        }
		return allTeammate;
    }
	public Teammate getTeammate(String teammatename, String projectName) throws Exception {
		List<Teammate> allTeammate = getAllTeammate(projectName);
		//System.out.println();
				for(Teammate t : allTeammate) {
					//System.out.println(t.name);
					if(teammatename.equals(t.name)) {
						return t;
					}
				}
			return null;
	}
	
	

}