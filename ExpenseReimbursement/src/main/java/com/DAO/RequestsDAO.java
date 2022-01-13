package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Model.Employees;
import com.Model.Requests;
import com.util.ConnectionUtil;

public class RequestsDAO {

	public RequestsDAO() {};
	
	public Boolean submitReq(Requests request){
		
		try {

			
			String sqlQuery = "insert into Requests (RequestStatusID,EmployeeID, Amount, RequestFor, isPast)  select 1, "+request.getEmployeeID()+"," + request.getAmount() +",'"+ request.getRequestFor()+"' ,  false ;";
			
			ConnectionUtil connectionUtil = new ConnectionUtil();
			Connection conn = connectionUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			statement.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	public ArrayList<Requests> viewSpecPendingReq (int employeeID) {
		ArrayList<Requests> requests = new ArrayList<Requests>();
		
		try {

			String sqlQuery = "  select RequestID, Amount, RequestFor from Requests \r\n"
					+ "       where ispast = false "
					+ "       and EmployeeID = "+employeeID+";";
			
			ConnectionUtil connectionUtil = new ConnectionUtil();
			Connection conn = connectionUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			System.out.println(sqlQuery);
			statement.executeQuery();
		    
			ResultSet results = statement.executeQuery();
			while (results.next())
			{
				Requests specReq = new Requests(); 
				specReq.setAmount(results.getFloat("Amount"));
				specReq.setRequestFor(results.getString("RequestFor"));
				specReq.setRequestID(results.getInt("RequestID"));
				specReq.setEmployeeID(employeeID);
				requests.add(specReq);
			}
			return requests;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	public ArrayList<Requests> viewSpecResolvedReq (int employeeID) {
		ArrayList<Requests> requests = new ArrayList<Requests>();
		
		try {

			String sqlQuery = "  select rq.RequestID, rq.Amount, rq.RequestFor, rs.requeststatusname from Requests rq \r\n" 
					+ "		  inner join Request_status rs on rq.requeststatusid = rs.requeststatusid "
					+ "      and rq.ispast = true "
					+ "       and rq.EmployeeID = "+employeeID+";";
			
			ConnectionUtil connectionUtil = new ConnectionUtil();
			Connection conn = connectionUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			System.out.println(sqlQuery);
		    
			ResultSet results = statement.executeQuery();
			while (results.next())
			{
				Requests specReq = new Requests(); 
				specReq.setAmount(results.getFloat("Amount"));
				specReq.setRequestFor(results.getString("RequestFor"));
				specReq.setRequestID(results.getInt("RequestID"));
				specReq.setEmployeeID(employeeID);
				specReq.setRequestStatusName(results.getString("RequestStatusName"));
				requests.add(specReq);
			}
			return requests;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	public ArrayList<Requests>  viewAllPendingReq() {
		ArrayList<Requests> requests = new ArrayList<Requests>();
		
		try {

			
			String sqlQuery = " select RequestID, Amount, RequestFor,EmployeeID from Requests \r\n"
					+    "          where isPast= false;";
			
			ConnectionUtil connectionUtil = new ConnectionUtil();
			Connection conn = connectionUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			statement.executeQuery();
		   Requests allPendReq = new Requests(); 
			ResultSet results = statement.executeQuery();
			while (results.next())
			{
				allPendReq.setAmount(results.getFloat("Amount"));
				allPendReq.setRequestFor(results.getString("RequestFor"));
				allPendReq.setRequestID(results.getInt("RequestID"));
				allPendReq.setEmployeeID(results.getInt("EmployeeID"));
			}
			return requests;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return null;		
			
	}
	
	public void approveReq(int requestID) {
		try {

			
			String sqlQuery = "  update  Requests\r\n"
					+ "        set RequestStatusID = 2 , ispast = true\r\n"
					+ "        where RequestID ='" + requestID + "';";
			
			ConnectionUtil connectionUtil = new ConnectionUtil();
			Connection conn = connectionUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			statement.executeUpdate();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}	
	
	public void denyReq(int requestID) {	
		try {

		
		String sqlQuery = "  update  Requests\r\n"
				+ "        set RequestStatusID = 3 , ispast = true\r\n"
				+ "        where RequestID ='" + requestID + "';";
		
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Connection conn = connectionUtil.getConnection();
		PreparedStatement statement = conn.prepareStatement(sqlQuery);
		statement.executeUpdate();
	
			}
		catch(Exception e)
			{
		e.printStackTrace();
			}
	
	}
	
	public ArrayList<Requests> viewAllPastReq() {
		ArrayList<Requests> requests = new ArrayList<Requests>();
		
		try {

			
			String sqlQuery = " select  RequestID, RequestStatusID, Amount, RequestFor,EmployeeID from Requests \r\n"
					+ "                   where ispast = true;";
			
			ConnectionUtil connectionUtil = new ConnectionUtil();
			Connection conn = connectionUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			statement.executeQuery();
		    Requests allPastReq = new Requests(); 
			ResultSet results = statement.executeQuery();
			while (results.next())
				{
				
				allPastReq.setAmount(results.getFloat("Amount"));
				allPastReq.setEmployeeID(results.getInt("EmployeeID"));
				allPastReq.setRequestFor(results.getString("RequestFor"));
				allPastReq.setRequestID(results.getInt("RequestID"));
				allPastReq.setEmployeeID(results.getInt("RequestStatusID"));
				}
			return requests;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public Requests  viewSpecReq(int employeeID) {
		
		try {

			
			String sqlQuery = " select RequestID, RequestStatusID, Amount, RequestFor, isPast from REQUESTS    \r\n"
					+ "             where EmployeeID = "+ employeeID  + ";";
			
			ConnectionUtil connectionUtil = new ConnectionUtil();
			Connection conn = connectionUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(sqlQuery);
			statement.executeQuery();
		     Requests specReq = new Requests(); 
			ResultSet results = statement.executeQuery();
			while (results.next())
			{
				specReq.setPast(results.getBoolean("isPast"));
				specReq.setAmount(results.getFloat("Amount"));
				specReq.setRequestFor(results.getString("RequestFor"));
				specReq.setRequestID(results.getInt("RequestID"));
				specReq.setEmployeeID(results.getInt("RequestStatusID"));
			}
			
			return specReq;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
			}
	
	








