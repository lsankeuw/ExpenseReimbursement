package com.expense.demo;

import org.apache.log4j.Logger;

import com.expense.controller.EmployeeController;
import com.expense.controller.RequestsController;

import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import io.javalin.http.Handler;
import io.javalin.http.staticfiles.Location;
import jdk.javadoc.internal.tool.Start;

public class Main {
	public final static Logger log = Logger.getLogger(Main.class.getName());
public static void main(String [] args) {
	org.apache.log4j.BasicConfigurator.configure();
	Javalin app = Javalin.create(ctx -> {
		ctx.enableCorsForAllOrigins();
		ctx.addStaticFiles("web", Location.CLASSPATH);
		
	}).start(7001);
	//log.info("Hello");
	app.get("/hello/{name}", ctx-> ctx.result("Hello Again" + ctx.pathParam("name")));
	app.get("/controller", EmployeeController.controller);
	
//	app.get("/login", EmployeeController.employeeLogin);
	app.post("/login", EmployeeController.employeeLogIn);
	app.post("/submitreq", RequestsController.submitReq);
	app.post("/employeeinfos", EmployeeController.viewEmpInformation);
	app.post("/updateinfos", EmployeeController.updateEmpInformation);
    app.post("/getspecificpendingrequests", RequestsController.viewSpecPendingReq);
    app.post("/getspecificresolvedrequests", RequestsController.viewSpecResolvedReq);
   app.post("/pastreq", RequestsController.viewAllPastReq);

/*
    app.post("/requests/approve", RequestsController.approveReq);
    app.post("/requests", RequestsController.denyReq);
    app.get("/requests/pastreq", RequestsController.viewAllPastReq);  
    app.get("/requests/allpendreq", RequestsController.viewAllPendingReq);	
    app.get("/requests/specreq", RequestsController.viewSpecReq);
*/
}
}
		

