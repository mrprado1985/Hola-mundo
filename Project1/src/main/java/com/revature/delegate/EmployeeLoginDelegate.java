package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.util.LoggingUtil;

public class EmployeeLoginDelegate {
	static String userSession;
	static String passwordSession;
	final static Logger log = Logger.getLogger(LoggingUtil.class);
	
	public EmployeeDao ed = new EmployeeDaoImpl();
	
	public void employeeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("eUser");
		String password = request.getParameter("ePass");
		Employee loggedEmployee = ed.getEmployee(username, password);
		if(loggedEmployee == null ) {
			response.sendRedirect("http://localhost:8080/Project1/html/LoginPage.html");
			log.error("Unsuccessful login attempt!");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("eUser", username);
			session.setAttribute("ePass", password);
			userSession = (String) session.getAttribute("eUser");
			passwordSession = (String) session.getAttribute("ePass");
			response.sendRedirect(request.getContextPath()+"/html/EmployeeHomePage.html");
			log.info(userSession + " has logged in.");
		}
	}
	public void employeeLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.info(userSession + " has logged out.");
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("http://localhost:8080/Project1/html/LoginPage.html");
	}
	
	public void myEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Employee loggedEmployee = ed.getEmployee(userSession, passwordSession);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<table><tr>");
		pw.println("<th>First Name</th>");
		pw.println("<th>Last Name</th>");
		pw.println("<th>Email</th></tr> <br>");
		pw.println("<tr>"
				+ " <td>" + loggedEmployee.getFirstName() + "</td>");
		pw.println("<td>" + loggedEmployee.getLastName() + "</td>");
		pw.println("<td>" + loggedEmployee.getEmail() + "</td></tr></table>");
	}
	
	public void editEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String firstName = request.getParameter("firstName");
		String password = request.getParameter("ePass");
		String email = request.getParameter("email");
		String lastName = request.getParameter("lastName");
		Employee inputEmployee = new Employee(email, password, firstName, lastName, userSession);
		ed.updateEmployee(inputEmployee);
		PrintWriter pw = response.getWriter();
		pw.println("You have successfully edited your information!");
		pw.println("Here is a summary of your new account information:");
		pw.println("First Name: " + inputEmployee.getFirstName());
		pw.println("Last Name: " + inputEmployee.getLastName());
		pw.println("Email: " + inputEmployee.getEmail());
		pw.println("Password: " + inputEmployee.getPassword());
		log.info(userSession + " has edited their account.");
		response.sendRedirect("http://localhost:8080/Project1/html/LoginPage.html");
	}
}