package com.Model;

import java.util.ArrayList;

public class ControllerResult {
	Boolean success;
	ArrayList<Requests> requests;
	
	public ControllerResult(ArrayList<Requests> incomingRequests){
		this.requests = incomingRequests;
	};
	
	public ArrayList<Requests> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<Requests> requests) {
		this.requests = requests;
	}

	public Boolean getSuccess() {
		return success;
	}

	public ControllerResult(Boolean success) {
		super();
		this.success = success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

    
}
