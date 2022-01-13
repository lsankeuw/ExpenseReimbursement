package com.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.Model.Employees;
import com.util.ConnectionUtil;

public class EmployeesDAO {
       
	public EmployeesDAO(){};
	
	/*
public Employees employeeLogin(String username, String pwd) {
	int eID = 0;
	 Employees employee = new Employees();
	System.out.println(username);
	System.out.println(pwd);
	try {
		
		//String sqlQuery = "select EmployeeID, isManager from Employees where username = '"+ username +"' and pwd = '"+ pwd +"' ;";
		String sqlQuery = "select employeeid, isManager from Employees where username =?  and pwd =? ";
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection conn = connectionUtil.getConnection();
		PreparedStatement statement = conn.prepareStatement(sqlQuery);
		int parameterIndex=0;
		statement.setString(1, username);
		statement.setString(2, pwd);
		ResultSet results = statement.executeQuery();
	    
		System.out.println(sqlQuery);
		while (results.next())
		
			{
			employee.setEmployeeID(results.getInt("employeeid"));
			employee.setManager(results.getBoolean("isManager"));
			System.out.println(eID);
			System.out.println("hello");
			}
		}
	
	
	catch (Exception e)
		{
		System.out.println("employeeLogin error :" + e.getMessage());
		e.printStackTrace(); 

		}
	return employee;
}  
*/
public static Connection getConnection() throws SQLException, IOException {
	Connection conn;
	FileInputStream propinput = new FileInputStream( "C:\\Users\\blanc\\OneDrive\\Documents\\JDBC-Setup.txt");
	Properties props = new Properties();
	props.load(propinput);
	String url = (String) props.get("url");
	String username = (String) props.get("username");
	String password = (String) props.get("password");
	
	return DriverManager.getConnection(url, username, password);
	
}


	
	
//Login info query method
public static ArrayList<Employees> employeeLogIn0(String userN, String passW) throws SQLException {
	ArrayList<Employees> empInq = new ArrayList<Employees>();
	try(Connection conn = getConnection()){
        System.out.println("Connection successful");
        
		PreparedStatement statement = conn.prepareStatement("select * from Employees where username =?  and pwd =? LIMIT 1");
        
		statement.setString(1, userN);
		statement.setString(2, passW);
		
        ResultSet results = statement.executeQuery();
        System.out.println(statement);
        
        while(results.next()){

        empInq.add(new Employees(results.getInt("employeeID"),results.getString("fullName"),
        		results.getString("username"),results.getString("pwd"),
        		results.getBoolean("isManager")));
        	       	
        }
        
        
    }catch(Exception e){
    	System.out.println(e.getMessage());
    }
        //e.p
	return empInq;

	
}


public Employees viewEmpInformation( int employeeID ) throws SQLException { 
	//ArrayList<Employees> empInfo = new ArrayList<Employees>();
try {

	
	String sqlQuery = "select FullName, Username from Employees where employeeID = "+ employeeID + ";";
	
	ConnectionUtil connectionUtil = new ConnectionUtil();
	Connection conn = connectionUtil.getConnection();
	PreparedStatement statement = conn.prepareStatement(sqlQuery);
	statement.executeQuery();
	
	Employees employeeInfo = new Employees(employeeID, sqlQuery, sqlQuery, sqlQuery, false);
	ResultSet results = statement.executeQuery();
	while (results.next())
	{

	employeeInfo.setFullName(results.getString("FullName"));
		employeeInfo.setUsername(results.getString("Username")); 
	}
	
return employeeInfo;
}
catch(Exception e)
{ 
	System.out.println("viewEmpInformation error :" + e.getMessage());
	e.printStackTrace();
	return null;
}


}



public Boolean updateEmpInformation(Employees employee) {
	
	try 	
	{
	
		String sqlQuery = "update  EMPLOYEES set username = '"+ employee.username + "', pwd = '"+ employee.pwd+"', "
				+ "fullName = '"+ employee.fullName+"' where EmployeeID = "+ employee.employeeID + " ;";

		
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection conn = connectionUtil.getConnection();
		PreparedStatement statement = conn.prepareStatement(sqlQuery);
		System.out.println(sqlQuery);
		statement.executeUpdate();
		return true;
	}
	catch(Exception e)
	{
		System.out.println( e.getMessage());
		e.printStackTrace();
		return false;
	}
		
}
	public static void main(String[] args) throws SQLException {
       EmployeesDAO employee = new EmployeesDAO();
       employee.employeeLogIn0("Fred150", "FAnthony");
       for(Employees e: employee.employeeLogIn0("FAnthony", "Fred150")) {
   		System.out.println(e.toString());
   	}
  
}
}
