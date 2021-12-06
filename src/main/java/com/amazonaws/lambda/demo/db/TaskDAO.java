package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Task;



public class TaskDAO {
	
	java.sql.Connection conn;
	
	final String tb1name = "Task";
	
	public TaskDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
		
	}

	public Task getTask(String id) throws Exception{
		
		try {
			Task task = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE TaskName=?;");
			ps.setString(1,  id);
			ResultSet resultSet = ps.executeQuery();
			
			  while (resultSet.next()) {
	                task = generateTask(resultSet);
	            }
			resultSet.close();
			ps.close();
			return task;
			  
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting task: " + e.getMessage());
		}
		
	}

	public boolean addTask(Task task) throws Exception {
		// TODO Auto-generated method stub
		try {
			
			 PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE taskName = ?;");
	            ps.setString(1, task.name);
	            ResultSet resultSet = ps.executeQuery();
	            
	            // already present?
	            while (resultSet.next()) {
	                Task c = generateTask(resultSet);
	                resultSet.close();
	                return false;
	            }
	            
			 // = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE projectName = ?;");
			
			 ps = conn.prepareStatement("INSERT INTO " + tb1name + " (taskName, taskID, projectname, order2) values(?,?,?,?);");
	            ps.setString(1,  task.name); // fix
	            ps.setInt(2,  task.id); 
	            ps.setString(3, task.projectName);
	            ps.setInt(4, task.order);
	            System.out.println();
	            ps.execute();
	            return true;
			}
		catch (Exception e){
            throw new Exception("Failed to insert task: " + e.getMessage());

			}
		}
		

	
	private Task generateTask(ResultSet resultSet) throws Exception {
		String name = resultSet.getString("taskName");
		int id = resultSet.getInt("taskID");
		String projectName = resultSet.getString("projectName");
				
		return new Task(name, id, projectName);
		
	}

	public List<Task> getAllTasks(String projectName) throws Exception {
	// TODO Auto-generated method stub	
		List<Task> allTasks = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM " + tb1name + "ORDER by order2";//+ "where projectname = "+ projectName + ";";// + "ORDER BY order2;"
            //SELECT * FROM  Task where projectname ="47be12e7-8c88-4120-ad61-f42ba538ca93";
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

        } catch (Exception e) {
            throw new Exception("Failed in getting tasks: " + e.getMessage());
        }
		return allTasks;
    }
	
    
}
