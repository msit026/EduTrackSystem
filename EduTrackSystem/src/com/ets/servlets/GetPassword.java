package com.ets.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.Admin;

/**
 * Servlet implementation class GetPassword
 */
public class GetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String username = "";
		if(request.getSession().getAttribute("username") != null)
			username = request.getSession().getAttribute("username").toString();
		
		if(request.getAttribute("userType").toString().equalsIgnoreCase("admin"))
		{
			if(username != "")
			{
				Admin admin = new Admin();
				//request.setAttribute("oldPassword", admin.getPassword());
				request.setAttribute("oldPassword","admin");
			}
			try
			{
				RequestDispatcher rd = request.getRequestDispatcher("AdminEditProfile.jsp");
				rd.include(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
