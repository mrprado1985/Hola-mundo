package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.RequestDao;
import com.revature.dao.RequestDaoImpl;
import com.revature.model.Request;
import com.revature.util.LoggingUtil;

public class ReimbursementDelegate {
	
	public RequestDao rd = new RequestDaoImpl();
	final static Logger log = Logger.getLogger(LoggingUtil.class);
	
	public void submitRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		float requestAmount = Float.parseFloat(request.getParameter("requestAmount"));
		String purpose = request.getParameter("purpose");
		String status = "pending";
		String reviewedBy = null;
		String reviewedDate = null;
	    String requestDate = null; 
		Request newRequest = new Request(0, requestAmount, EmployeeLoginDelegate.userSession, reviewedBy, status, purpose, requestDate, reviewedDate);
		rd.insertRequest(newRequest);
		PrintWriter pw = response.getWriter();
		pw.println("Request Submitted!");
		pw.println("Pending Review...");
		log.info("new request created by: " + EmployeeLoginDelegate.userSession);
		

		response.sendRedirect("http://localhost:8080/project11/html/EmployeeHomePage.html");
	}
	
	public void employeePendingRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List <Request> pendingRequests = new ArrayList<>();
		pendingRequests = rd.getAllPendingRequest();
		PrintWriter pw = response.getWriter();
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
	
	for (int i = 0; i<pendingRequests.size(); i++) {
		Request Current = pendingRequests.get(i);
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

	
	public void employeeResolvedRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List <Request> resolvedRequests = new ArrayList<>();
		resolvedRequests = rd.getAllResolvedRequest();
		PrintWriter pw = response.getWriter();
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
	
	for (int i = 0; i<resolvedRequests.size(); i++) {
		Request Current = resolvedRequests.get(i);
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
	
	public void specificPendingRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List <Request> pendingRequests = new ArrayList<>();
		pendingRequests = rd.getAllPendingRequest(EmployeeLoginDelegate.userSession);
		PrintWriter pw = response.getWriter();
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
	
	for (int i = 0; i<pendingRequests.size(); i++) {
		Request Current = pendingRequests.get(i);
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
	
	public void specificResolvedRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List <Request> resolvedRequests = new ArrayList<>();
		resolvedRequests = rd.getAllResolvedRequest(EmployeeLoginDelegate.userSession);
		PrintWriter pw = response.getWriter();
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
	
	for (int i = 0; i<resolvedRequests.size(); i++) {
		Request Current = resolvedRequests.get(i);
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
}