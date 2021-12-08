package com.amazonaws.lambda.demo;


package com.amazonaws.lambda.demo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

import com.amazonaws.lambda.demo.db.ProjectsDAO;
import com.amazonaws.lambda.demo.db.TaskDAO;
import com.amazonaws.lambda.demo.http.DeleteProjectRequest;
import com.amazonaws.lambda.demo.http.DeleteProjectResponse;
import com.amazonaws.lambda.demo.http.GetProjectRequest;
import com.amazonaws.lambda.demo.http.GetProjectResponse;
import com.amazonaws.lambda.demo.http.RenameTaskRequest;
import com.amazonaws.lambda.demo.http.RenameTaskResponse;
import com.amazonaws.lambda.demo.model.Project;
import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;



public abstract class RenameTaskHandler implements RequestHandler<RenameTaskRequest, RenameTaskResponse> {

	public LambdaLogger logger;
	
    // To access S3 storage
    @SuppressWarnings("unused")
    private AmazonS3 s3 = null;

    public static final String REAL_BUCKET = "task/";

    /** Store into RDS.
     * 
     * @throws Exception 
     */
	

	    boolean RenameTask(String name ,String projectName) throws Exception { 
	        if (logger != null) { logger.log("in renameTask"); }
	        TaskDAO dao = new TaskDAO();

	        // check if present
	        Task exist = dao.getTask(name);

	        Task task = new Task(name, projectName);
	        if (exist != null) {
	            return dao.RenameTask(task);
	        } else {
	            return false;
	        }
	    }

	

	
}
