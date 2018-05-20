package com.revature.service;

import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;


public class EmployeeService {

	private static EmployeeDao dao = new EmployeeDaoImpl();

	public static boolean insertEmployee(Employee inputEmployee) {
		return dao.insertEmployee(inputEmployee);
	}
	
	public static Employee getEmployee(String username, String password) {
		return dao.getEmployee(username, password);
	}

	public static List<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}

	public static boolean updateEmployee(Employee inputEmployee) {
		return dao.updateEmployee(inputEmployee);
	}

}