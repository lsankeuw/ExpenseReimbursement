package com.expense.controller;

import java.util.ArrayList;

import com.DAO.EmployeesDAO;
import com.DAO.RequestsDAO;
import com.Model.ControllerResult;
import com.Model.Employees;
import com.Model.Requests;

import io.javalin.http.Handler;

public class RequestsController {

	
	public static Handler submitReq =  ctx ->{
		
		RequestsDAO requestsDAO = new RequestsDAO();
   	
		Requests request = ctx.bodyAsClass(Requests.class);	
		ControllerResult result = new ControllerResult(requestsDAO.submitReq(request));

		ctx.json(result);
	   
	};
	
	public static Handler viewSpecPendingReq = ctx ->{
		
		RequestsDAO requestsDAO = new RequestsDAO();
		
        Employees employee = ctx.bodyAsClass(Employees.class);	
        ArrayList <Requests> pendingRequests =  requestsDAO.viewSpecPendingReq(employee.getEmployeeID());
        ControllerResult result = new ControllerResult(pendingRequests);

		ctx.json(result);
	};
	
public static Handler viewSpecResolvedReq = ctx ->{
		
		RequestsDAO requestsDAO = new RequestsDAO();
		
        Employees employee = ctx.bodyAsClass(Employees.class);	
        ArrayList <Requests> resolvedRequests =  requestsDAO.viewSpecResolvedReq(employee.getEmployeeID());
        ControllerResult result = new ControllerResult(resolvedRequests);

		ctx.json(result);
	};
	
	public static Handler viewAllPastReq = ctx -> {
	RequestsDAO requestsDAO = new RequestsDAO();
		
        Employees employee = ctx.bodyAsClass(Employees.class);	
        ArrayList <Requests> resolvedRequests =  requestsDAO.viewAllPastReq();
        ControllerResult result = new ControllerResult(resolvedRequests);

		ctx.json(result);
		
	};
	
	/*
	public static Handler viewAllPendingReq = ctx -> {
		RequestsDAO requestsDAO = new RequestsDAO();
		Requests r = new Requests();
		Requests allPendReq = requestsDAO.viewAllPendingReq();
		ctx.json(allPendReq);
	};
	public static Handler approveReq = ctx -> {
		RequestsDAO requestsDAO = new RequestsDAO();
		Requests r = new Requests();
		int requestID = r.getRequestID();
		ctx.redirect("/requests/allpendreq");
	};
	public static Handler denyReq = ctx -> {
		RequestsDAO requestsDAO = new RequestsDAO();
		Requests r = new Requests();
		int requestID = r.getRequestID();
		ctx.redirect("/requests/allpendreq");
	};
	
	};
	public static Handler viewSpecReq = ctx -> {
	RequestsDAO requestsDAO = new RequestsDAO();
	Requests r = new Requests();
	int employeeID = r.getEmployeeID();
	Requests SpecReq = requestsDAO.viewSpecReq(employeeID);
	ctx.json(SpecReq);
};
*/
}
