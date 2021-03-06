package com.amazonaws.lambda.demo;


import com.amazonaws.lambda.demo.db.TaskDAO;

import com.amazonaws.lambda.demo.http.CreateTaskRequest;
import com.amazonaws.lambda.demo.http.CreateTaskResponse;

import com.amazonaws.lambda.demo.model.Task;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;

public class CreateTaskHandler implements RequestHandler<CreateTaskRequest, CreateTaskResponse> {

    LambdaLogger logger;

    boolean createTask(String name, String projectName) throws Exception { 
        if (logger != null) { logger.log("in createTask"); }
        TaskDAO dao = new TaskDAO();

        // check if present
        Task exist = dao.getTask(name, projectName);

        Task task = new Task(name, projectName);
        if (exist == null) {
            return dao.addTask(task);
        } else {
            return false;
        }
    }

    @Override 
    public CreateTaskResponse handleRequest(CreateTaskRequest req, Context context)  {
        logger = context.getLogger();
        logger.log(req.toString());

        CreateTaskResponse response;
        try {
            if (createTask(req.name, req.projectName)) {
                    response = new CreateTaskResponse(req.name);
            } 
            else {
                    response = new CreateTaskResponse(req.name, 400);
            }

        } catch (Exception e) {
            response = new CreateTaskResponse("Unable to create task: " + req.name + "(" + e.getMessage() + ")", 400);
        }

        return response;
    }

}