package com.Model;

public class Requests {
	 int  RequestID ; 
	 int RequestStatusID ; 
     int EmployeeID  ;
     float  Amount ;
     String RequestFor;
     boolean isPast ;
     String RequestStatusName;
     
     public String getRequestStatusName() {
		return RequestStatusName;
	}
	public void setRequestStatusName(String requestStatusName) {
		RequestStatusName = requestStatusName;
	}
	public Requests(int requestID, int requestStatusID, int employeeID, float amount, String requestFor,
			boolean isPast) {
		super();
		RequestID = requestID;
		RequestStatusID = requestStatusID;
		EmployeeID = employeeID;
		Amount = amount;
		RequestFor = requestFor;
		isPast = isPast;
	} 
     public Requests() {};
	public int getRequestID() {
		return RequestID;
	}
	public void setRequestID(int requestID) {
		RequestID = requestID;
	}
	public int getRequestStatusID() {
		return RequestStatusID;
	}
	public void setRequestStatusID(int requestStatusID) {
		RequestStatusID = requestStatusID;
	}
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public String getRequestFor() {
		return RequestFor;
	}
	public void setRequestFor(String requestFor) {
		RequestFor = requestFor;
	}
	public boolean isPast() {
		return isPast;
	}
	public void setPast(boolean isPast) {
		this.isPast = isPast;
	} 
     
     
     
     
     
     
     
     
     
     
     
     
     
}
