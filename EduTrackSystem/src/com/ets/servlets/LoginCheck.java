package com.ets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		Admin a = new Admin();
		HttpSession session = request.getSession();

		if (a.isValidUser(request.getParameter("userName"),
				request.getParameter("LoginPassword"))) {
			
			session.setAttribute("userType", "admin");
			session.setAttribute("userId", a.getAdmin_username());
			response.sendRedirect("adminHomePage.html");
		}
		
		else {
			Student s = new Student();
			Mentor m = new Mentor();

			if (s.isValidUser(request.getParameter("userName"),
					request.getParameter("LoginPassword"))) {
				request.getSession().setAttribute("userType", "student");
				session.setAttribute("userDetails", s.getAllDetails(request.getParameter("userName")));   
				response.sendRedirect("StudentHomePage.html");
			} 
			
			else if (m.isValidUser(request.getParameter("userName"),
					request.getParameter("LoginPassword"))) {
				
				session.setAttribute("userDetails", s.getAllDetails(request.getParameter("userName")));
				request.getSession().setAttribute("userType", "mentor");
				response.sendRedirect("MentorHomePage.html");
			} 
			
			else {
				request.setAttribute("invalid", "invalid");
				response.sendRedirect("invalid.html");
			}
		}
		// later we can write for the sessions
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
