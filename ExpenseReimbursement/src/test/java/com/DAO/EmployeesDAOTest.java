package com.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Model.Employees;

class EmployeesDAOTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEmployeesDAO() {
		fail("Not yet implemented");
		
	}

	@Test
	void testGetConnection() {
		fail("Not yet implemented");
	}

	@Test
	void testEmployeeLogIn0() throws SQLException {
		
		EmployeesDAO ed = new EmployeesDAO();
		//Exception scenario 1:
		String userN = "abc";
		String passW =  "abcd";
	
		ArrayList<Employees> employeeLogIn0 = ed.employeeLogIn0(userN, passW);
		Assert.assertNotNull(employeeLogIn0);
		Assert.assertEquals(0, employeeLogIn0.size());
	
	
	//Exception scenario 2:
	 userN = "hello";
	 passW =  "world";
	employeeLogIn0 = ed.employeeLogIn0(userN, passW);
	Assert.assertNotNull(employeeLogIn0);
	Assert.assertEquals(0, employeeLogIn0.size());
	
	//standard scenario1
	userN = "FAntho";
	 passW =  "now";
	 employeeLogIn0 = ed.employeeLogIn0(userN, passW);
		Assert.assertNotNull(employeeLogIn0);
		Assert.assertEquals(1, employeeLogIn0.size());
	 for(int i=0; i<employeeLogIn0.size(); i++) {
		 Assert.assertTrue(employeeLogIn0.get(i).getUsername().toLowerCase(), false);
		 Assert.assertTrue(employeeLogIn0.get(i).getPwd().toLowerCase(), false);
	 }
	
	//standard scenario2
	 userN = "HMiles";
	 passW =  "helene9200";
	 employeeLogIn0 = ed.employeeLogIn0(userN, passW);
		Assert.assertNotNull(employeeLogIn0);
		Assert.assertEquals(1, employeeLogIn0.size());
	 for(int i=0; i<employeeLogIn0.size(); i++) {
		 Assert.assertTrue(employeeLogIn0.get(i).getUsername().toLowerCase(),true);
		 Assert.assertTrue(employeeLogIn0.get(i).getPwd().toLowerCase(),true);
	 }
}
	@Test
	void testViewEmpInformation() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateEmpInformation() {
		fail("Not yet implemented");
	}

	@Test
	void testMain() {
		fail("Not yet implemented");
	}

}
