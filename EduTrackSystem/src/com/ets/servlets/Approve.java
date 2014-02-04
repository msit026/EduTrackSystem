package com.ets.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.Admin;

/**
 * Servlet implementation class Approve
 */
public class Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approve() {
        super();
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Admin admin = new Admin();
    	String []selectedStudents = request.getParameterValues("checkedRows");
    	PrintWriter out = response.getWriter();
    	
    	boolean flag = admin.ApproveStudetns(selectedStudents);
    	if(flag)
    	{
    		out.println("Approved");
    		RequestDispatcher dispatch = request.getRequestDispatcher("ShowPendingRequestsServlet");
    		dispatch.include(request, response);
    	}
    	else
    	{
    		out.println("Not Approved");
    		RequestDispatcher dispatch = request.getRequestDispatcher("ShowPendingRequestsServlet");
    		dispatch.include(request, response);
    	}
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	

}
