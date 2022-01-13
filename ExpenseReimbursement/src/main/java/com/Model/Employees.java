package com.Model;

public class Employees {
	public int employeeID; 
	public String fullName; 
	public String username; 
	public String pwd;
	public boolean isManager;
	
	
	@Override
	public String toString() {
		return "Employees [EmployeeID=" + employeeID + ", FullName=" + fullName + ", Username=" + username + ", Pwd="
				+ pwd + ", isManager=" + isManager + "]";
	}

    
	public Employees(int employeeID, String fullName, String username, String pwd, boolean isManager) {
		super();
		this.employeeID = employeeID;
		this.fullName = fullName;
		this.username = username;
		this.pwd = pwd;
		this.isManager = isManager;
	}



	public Employees() {
		// TODO Auto-generated constructor stub
	}


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public boolean isManager() {
		return isManager;
	}


	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

    
    
} 
