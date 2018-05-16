package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;
import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.model.Request;
import com.revature.util.LoggingUtil;

public class ManagerDelegate {
	public ManagerDao md = new ManagerDaoImpl();
	static String userSession;
	final static Logger log = Logger.getLogger(LoggingUtil.class);
	
	public void managerLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("mUser");
		String password = request.getParameter("mPass");
		Manager loggedManager = md.getManager(username, password);
		if(loggedManager == null) {
			response.sendRedirect("http://localhost:8080/project11/html/LoginPage.html");
			log.error("Unsuccessful login attempt!");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("mUser", username);
			userSession = (String) session.getAttribute("mUser");
			PrintWriter pw = response.getWriter();
			pw.println("You have logged in, " + loggedManager.getFirstName() + ".");
			response.sendRedirect(request.getContextPath()+"/html/ManagerHomePage.html");
			log.info(userSession + " has logged in.");
		}
	}
		
		public void managerLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
			log.info(userSession + " has logged out.");
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("http://localhost:8080/project11/html/LoginPage.html");
		}
		
		public void viewEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
			EmployeeDao ed = new EmployeeDaoImpl();
			List <Employee> allEmployee = new ArrayList<>();
			allEmployee = ed.getAllEmployee();
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			    pw.println("<table><tr>");
				pw.println("<th>First Name</th>");
				pw.println("<th>Last Name</th>");
				pw.println("<th>User Name</th>");
				pw.println("<th>Email</th></tr>");
			
			for (int i = 0; i<allEmployee.size(); i++) {
				Employee Current = allEmployee.get(i);
				pw.println("<tr>"
						+ "	<td>" + Current.getFirstName() + "</td>");
				pw.println("<td>" + Current.getLastName() + "</td>");
				pw.println("<td>" + Current.getUserName() + "</td>");
				pw.println("<td>" + Current.getEmail() + "</td></tr>");
			}
				pw.println("</table>");
			
		}
		
		public void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
			RequestDao rd = new RequestDaoImpl();
			PrintWriter pw = response.getWriter();
			List <Request> employeeRequest = new ArrayList<>();
			String searchedEmployee = request.getParameter("eUser");
			employeeRequest = rd.getAllRequest(searchedEmployee);
			response.setContentType("text/html");
		    pw.println("<table><tr>");
			pw.println("<th>Request ID</th>");
			pw.println("<th>Request Amount</th>");
			pw.println("<th>Purpose</th>");
			pw.println("<th>Status</th>");
			pw.println("<th>Requester</th>");
			pw.println("<th>Reviewed By</th>");
			pw.println("<th>Request Date</th>");
			pw.println("<th>Review Date</th></tr>");
		
		for (int i = 0; i<employeeRequest.size(); i++) {
			Request Current = employeeRequest.get(i);
			pw.println("<tr>"
					+ " <td>" + Current.getRequestID() + "</td>");
			pw.println("<td>" + Current.getRequestAmount() + "</td>");
			pw.println("<td>" + Current.getPurpose() + "</td>");
			pw.println("<td>" + Current.getStatus() + "</td>");
			pw.println("<td>" + Current.getRequester()+ "</td>");
			pw.println("<td>" + Current.getReviewedBy()+ "</td>");
			pw.println("<td>" + Current.getRequestDate()+ "</td>");
			pw.println("<td>" + Current.getReviewDate() + "</td></tr>");
		}
			pw.println("</table>");
		}
		
		public void approveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
			RequestDao rd = new RequestDaoImpl();
			int requestID = Integer.parseInt(request.getParameter("approveID"));
			rd.approveRequest(requestID, userSession);
			PrintWriter pw = response.getWriter();
			pw.print("The request id: " + requestID + " has been approved!");
			log.info(userSession + " has approved the requestID: " + requestID);
			response.sendRedirect("http://localhost:8080/project11/html/ManagerHomePage.html");
			
		}
		
		public void denyRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
			System.out.println("was this called?");
			RequestDao rd = new RequestDaoImpl();
			int requestID = Integer.parseInt(request.getParameter("denyID"));
			rd.denyRequest(requestID, userSession);
			PrintWriter pw = response.getWriter();
			pw.print("The request id: " + requestID + " has been denied!");
			log.info(userSession + " has denied the requestID: " + requestID);
			response.sendRedirect("http://localhost:8080/project11/html/ManagerHomePage.html");
		}
}