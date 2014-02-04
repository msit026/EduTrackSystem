package com.ets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.Admin;
import com.ets.classes.Mentor;
import com.ets.classes.Student;
import com.mysql.jdbc.Statement;

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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		//verifyUser vu=new verifyUser();
		Admin a = new Admin();
		
		
		
		if(a.isValidUser(request.getParameter("userName"),request.getParameter("LoginPassword")))
		{
			response.sendRedirect("adminHomePage.html");
		}
		else
		{
			Student s = new Student();
			Mentor m = new Mentor();
		
			if(s.isValidUser(request.getParameter("userName"),request.getParameter("LoginPassword")))
			{
				
				out.println("Welcome Student!");
			}
			else if(m.isValidUser(request.getParameter("userName"),request.getParameter("LoginPassword")))
			{
				out.println("Welcome Mentor!");
			}
			else
			{
				out.println("Sorry ... Invalid credentials");
			}
		}
		
		// later we can write for the sessions
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
