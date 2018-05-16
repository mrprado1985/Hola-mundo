package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;


public class getEmployeeShouldReturnEmployee {

	@Test
	public void testGetEmployee() {
		EmployeeDao ed = new EmployeeDaoImpl();
		assertTrue("No employee returned", ed.getEmployee("david", "password") != null);
	}
}
