package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

public class updateEmployeeShouldChangeDatabase {

	@Test
	public void testUpdateEmployee() {
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee testEmployee = new Employee();
		Employee updatedEmployee = new Employee();
		testEmployee = ed.getEmployee("david", "password");
		testEmployee.setFirstName("test");
		ed.updateEmployee(testEmployee);
		updatedEmployee = ed.getEmployee("david", "password");
		assertEquals("test", updatedEmployee.getFirstName());
	}

}
