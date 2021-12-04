package com.amazonaws.lambda.demo;

import org.junit.jupiter.api.Test;
import com.amazonaws.lambda.demo.db.TeammateDAO;
import com.amazonaws.lambda.demo.http.GetTeammateRequest;
import com.amazonaws.lambda.demo.http.GetTeammateResponse;
import com.amazonaws.lambda.demo.model.Teammate;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class CreateTeammateHandler implements RequestHandler<GetTeammateRequest, GetTeammateResponse> {
	
	/** Store into RDS.
	 * 
	 * @throws Exception 
	 */
	boolean createTeammate(String name) throws Exception { 

		TeammateDAO dao = new TeammateDAO();
		
		// check if present
		Teammate exist = dao.getTeammate(name);
		Teammate teammate = new Teammate(name);
		if (exist == null) {
			return dao.addTeammate(teammate);
		} else {
			return false;
		}
	}
	
	@Override 
	public GetTeammateResponse handleRequest(GetTeammateRequest req, Context context)  {

		GetTeammateResponse response;
		try {
			
			if (createTeammate(req.name)) {
					response = new GetTeammateResponse(req.name);
			} 
			else {
					response = new GetTeammateResponse(req.name, 400);
			}
			
		} catch (Exception e) {
			response = new GetTeammateResponse("Unable to create teammate: " + req.name + "(" + e.getMessage() + ")", 400);
		}

		return response;
	}


    public CreateTeammateHandler() {}

    
    @Test //if teammateName already exists within PROJECT
	public void testTeammateExists() {
		TeammateDAO  object= new TeammateDAO();
		boolean addedObject = true;
		Teammate teammate = null;
		try {
			teammate  = object.getTeammate("");
			if (teammate != null) {
				System.out.println("Teammate exists and can be added to project");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
		
		@Test	//if teammate does not exist and can be added to project (success)
		public void testTeammateDoesNotExist() {
			TeammateDAO  object= new TeammateDAO();
			boolean addedObject = false;
			Teammate teammate = null;
			try {
				teammate  = object.getTeammate("");
				if (teammate == null) {
					System.out.println("Teammate does not exist and can be added to project");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
