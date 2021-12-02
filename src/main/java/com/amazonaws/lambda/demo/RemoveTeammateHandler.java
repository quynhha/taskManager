package com.amazonaws.lambda.demo;

import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.http.RemoveTeammateRequest;
import com.amazonaws.lambda.demo.http.RemoveTeammateResponse;
import com.amazonaws.lambda.demo.model.Teammate;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class RemoveTeammateHandler implements RequestHandler<RemoveTeammateRequest, RemoveTeammateResponse> {

	LambdaLogger logger; 
	
	boolean removeTeammate(String name) throws Exception{
		if(logger != null ) {
			logger.log("Removin a Teammate ... ");
		}
		
		boolean result; 
		TeammateDAO dao = new TeammateDAO();
		
		Teammate exist = dao.getTeammate(name); 
		
		if(exist != null ) {
			result = dao.removeTeammate(name); 
		} else {
			result = false; 
		}
		return result;
	}
	
	
    @Override
    public RemoveTeammateResponse handleRequest(RemoveTeammateRequest req, Context context) {
        logger = context.getLogger();
        logger.log(req.toString());
        
        RemoveTeammateResponse resp;
        try {
        	if(removeTeammate(req.name)) {
        		resp = new RemoveTeammateResponse(req.name);
        	}
        	else {
        		resp = new RemoveTeammateResponse(req.name , 400);
        	}
        }catch (Exception e) {
        	resp = new RemoveTeammateResponse("Unable to remove the teammate: " + req.name + "(" + e.getMessage() + ")", 400);
        }
        return resp; 
    }

}
