package com.ets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ets.classes.Admin;
import com.ets.classes.Mentor;
import com.ets.classes.Student;

/**
 * Servlet implementation class loginCheck
 */
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		Admin admin = new Admin();
		HttpSession session = request.getSession();

		if (admin.isValidUser(request.getParameter("userName"),
				request.getParameter("LoginPassword"))) {
			
			session.setAttribute("userType", "admin");
			session.setAttribute("userId", admin.getAdmin_username());
			
			/**
			 * get the pending requests and display them on adminHomePage
			 */
			
			session.setAttribute("StudentPendingRequests", admin.getNumberOfPendingStudentRequests());
			session.setAttribute("MentorPendingRequests", admin.getNumberOfPendingMentorRequests());
			
			RequestDispatcher rd = request.getRequestDispatcher("adminHomePage.jsp");
			rd.include(request, response);
		}
		
		else {
			Student s = new Student();
			Mentor m = new Mentor();

			if (s.isValidUser(request.getParameter("userName"),request.getParameter("LoginPassword"))) {
				
				request.getSession().setAttribute("userType", "student");
				session.setAttribute("userDetails", s.getAllDetails(request.getParameter("userName")));
				
				/**
				 * Get the feedback notifications from the database and display them on student home page
				 */
				ResultSet rs = s.getFeedBackNotifications(request.getParameter("userName"));
				session.setAttribute("feedBackNotificationsResultSet",rs);
				String uname=request.getParameter("userName");
				session.setAttribute("uname", uname);
				RequestDispatcher rd = request.getRequestDispatcher("StudentHomePage.jsp");
				rd.include(request,response);
			} 
			
			else if (m.isValidUser(request.getParameter("userName"),
					request.getParameter("LoginPassword"))) {
				
				session.setAttribute("userDetails", m.getAllDetails(request.getParameter("userName")));
				request.getSession().setAttribute("userType", "mentor");
				session.setAttribute("uname", request.getParameter("userName"));
				RequestDispatcher rd = request.getRequestDispatcher("MentorHomePage.jsp");
				rd.include(request, response);
			} 
			
			else {
				request.setAttribute("invalid", "invalid");
				response.sendRedirect("invalid.jsp");
			}
		}
	}
}
