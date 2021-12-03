package com.amazonaws.lambda.demo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Teammate;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class TeammateDAO {
	
	java.sql.Connection conn;
	final String tb1name = "Teammate";
	private AmazonS3 s3;
	
	public TeammateDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
	}

	public Teammate getTeammate(String id) throws Exception{
		
		try {
			Teammate teammate = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE teammateName=?;");
			ps.setString(1,  id);
			ResultSet resultSet = ps.executeQuery();
			
			  while (resultSet.next()) {
	                teammate = generateTeammate(resultSet);
	            }
			resultSet.close();
			ps.close();
			return teammate;
			  
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting teammate: " + e.getMessage());
		}
		
	}

	public boolean addTeammate(Teammate teammate) throws Exception {
		// TODO Auto-generated method stub
		try {
			
			 PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE teammateName = ?;");
	            ps.setString(1, teammate.name);
	            ResultSet resultSet = ps.executeQuery();
	            
	            // already present?
	            while (resultSet.next()) {
	                Teammate t = generateTeammate(resultSet);
	                resultSet.close();
	                return false;
	            }
	            
			 // = conn.prepareStatement("SELECT * FROM " + tb1name + " WHERE teammateName = ?;");
			
			 ps = conn.prepareStatement("INSERT INTO " + tb1name + " (teammateName, teammateID) values(?,?);");
	            ps.setString(1,  teammate.name); // fix
	            ps.setInt(2,  teammate.id); 
	            System.out.println();
	            ps.execute();
	            return true;
			}
		catch (Exception e){
            throw new Exception("Failed to add teammate: " + e.getMessage());

			}
		}
		

	
	private Teammate generateTeammate(ResultSet resultSet) throws SQLException {
		String name = resultSet.getString("teammateName");
		int id = resultSet.getInt("teammateID");
				
		return new Teammate(name, id);
		
	}

	public List<Teammate> getAllTeammates() throws Exception {
	// TODO Auto-generated method stub	
		List<Teammate> allTeammates = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM " + tb1name + ";";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Teammate m = generateTeammate(resultSet);
                allTeammates.add(m);
            }
            resultSet.close();
            statement.close();
            return allTeammates;

        } catch (Exception e) {
            throw new Exception("Failed in getting teammates: " + e.getMessage());
        }
    }
	
	public boolean removeTeammate(String name) throws Exception {
		try {
			Teammate teammate = null;
			PreparedStatement ps = conn.prepareStatement("Delete FROM " + tb1name + " WHERE teammateName=?;");
			ps.setString(1,  name);
			int deleteCode = ps.executeUpdate();
			return deleteCode != 0;
			  
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Failed to delete teammate: " + e.getMessage());
		}	
	}   

    //private AmazonS3 s3 = AmazonS3ClientBuilder.standard().build();

    //public TeammateDAO() {}

    // Test purpose only.
    public TeammateDAO(AmazonS3 s3) {
        this.s3 = s3;
    }

		
    public String handleRequest(S3Event event, Context context) {
        context.getLogger().log("Received event: " + event);

        // Get the object from the event and show its content type
        String bucket = event.getRecords().get(0).getS3().getBucket().getName();
        String key = event.getRecords().get(0).getS3().getObject().getKey();
        try {
            S3Object response = s3.getObject(new GetObjectRequest(bucket, key));
            String contentType = response.getObjectMetadata().getContentType();
            context.getLogger().log("CONTENT TYPE: " + contentType);
            return contentType;
        } catch (Exception e) {
            e.printStackTrace();
            context.getLogger().log(String.format(
                "Error getting object %s from bucket %s. Make sure they exist and"
                + " your bucket is in the same region as this function.", key, bucket));
            throw e;
        }
    }
}
