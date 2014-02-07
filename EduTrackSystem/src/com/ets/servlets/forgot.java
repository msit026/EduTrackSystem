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

import com.ets.classes.PasswordGenerator;
import com.ets.classes.SendMail;
import com.ets.classes.passwordHelper;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class forgot
 */
public class forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println ("<html><body>");
		String email=request.getParameter("mail");
		passwordHelper ph=new passwordHelper();
		int flagUser=ph.findUser(email);
		
		//also call a class which would return a random passowrd.
		if(flagUser==1) //for student users
		{
			PasswordGenerator pg=new PasswordGenerator();
			String password = pg.generatedPasswordIs();
			passwordHelper ph1=new passwordHelper();
			ph1.saveStudentPassword(password, email);
			
			SendMail sm=new SendMail();
			boolean verify=sm.sendingMail(email, password);
			
			if(verify==true)
			{
				out.println("<h1>Your password has been sent to :"+email+"<h1>");
				response.setHeader("Refresh", "3;url=Login.html");  // to auto redirect 
			}
			
			else
			{
				out.println("<h1>An error has occured sending an email to you email id.<h1>");
				response.setHeader("Refresh", "3;url=Login.html"); //to auto redirect to login
			}
		}
		
		else if(flagUser==2) //for mentor users
		{
			PasswordGenerator pg=new PasswordGenerator();
			String password = pg.generatedPasswordIs();
			passwordHelper ph1=new passwordHelper();
			ph1.saveMentorPassword(password, email);
			
			SendMail sm=new SendMail();
			boolean verify=sm.sendingMail(email, password);
			
			if(verify==true)
			{
				/*out.println("<h1>Your password has been sent to :"+email+"<h1>");
				response.setHeader("Refresh", "3;url=Login.html"); //to auto redirect to login*/
				RequestDispatcher rd= request.getRequestDispatcher("SentMailNotify.html");
				rd.forward(request, response);
			}
			
			else
			{
				out.println("<h1>An error has occured sending an email to you email id.<h1>");
				response.setHeader("Refresh", "3;url=Login.html"); //to auto redirect to login
			}
		}
		
		else
		{
			out.println("<h1>Sorry Invalid Email. <h1>");
			response.setHeader("Refresh", "3;url=ForgetPassword.html");
			//response.sendRedirect("ForgetPassword.html");  
		}
	
	}

}
