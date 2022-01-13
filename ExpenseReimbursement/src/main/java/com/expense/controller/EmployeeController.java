package com.expense.controller;
import java.util.ArrayList;
import com.DAO.EmployeesDAO;
import com.Model.ControllerResult;
import com.Model.Employees;
import io.javalin.http.Handler;

public class EmployeeController {
	
	public static Handler controller = ctx -> {
		ctx.result("Hello from Controller");
		
	};	
	
public static Handler employeeLogIn = ctx -> {

	EmployeesDAO employeesDAO = new EmployeesDAO();
		Employees emp = ctx.bodyAsClass(Employees.class);
		
		ArrayList<Employees> empInq = employeesDAO.employeeLogIn0(emp.username,emp.pwd);
		
		ctx.json(empInq.get(0));				     
    };
    
    public static Handler viewEmpInformation = ctx -> {
    	EmployeesDAO employeesDAO = new EmployeesDAO();
    	Employees emp = ctx.bodyAsClass(Employees.class);	
       //  int employeeID = Integer.parseInt(ctx.formParam("employeeID"));
 	  Employees employeeinfo  = employeesDAO.viewEmpInformation(emp.employeeID);
    	ctx.json(employeeinfo);
    };

    public static Handler updateEmpInformation = ctx -> {
    	EmployeesDAO employeesDAO = new EmployeesDAO();
    	
    	Employees employee = ctx.bodyAsClass(Employees.class);	
       ControllerResult result = new ControllerResult(employeesDAO.updateEmpInformation(employee));

    	ctx.json(result);
    };
	

   

  
}

