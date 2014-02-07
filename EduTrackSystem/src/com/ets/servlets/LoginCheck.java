package com.ets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		if (a.isValidUser(request.getParameter("userName"),
				request.getParameter("LoginPassword"))) {
			response.sendRedirect("adminHomePage.html");
		} else {
			Student s = new Student();
			Mentor m = new Mentor();

			if (s.isValidUser(request.getParameter("userName"),
					request.getParameter("LoginPassword"))) {

				response.sendRedirect("studentHomePage.html");
			} else if (m.isValidUser(request.getParameter("userName"),
					request.getParameter("LoginPassword"))) {
				response.sendRedirect("mentorHomePage.html");
			} else {
				request.setAttribute("invalid", "invalid");
				response.sendRedirect("invalid.jsp");
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
