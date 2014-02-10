package com.ets.servlets;

/**
 * @author Mani
 */
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

    /**
     * It Processes the Request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Admin admin = new Admin();
    	String []selectedStudents = request.getParameterValues("checkedRows");
    	PrintWriter out = response.getWriter();
    	
    	boolean flag = admin.ApproveStudetns(selectedStudents);
    	if(flag)
    	{
    		out.println("<center><h5>Approved</h5></center>");
    		response.setHeader("refresh","3;URL=ShowPendingRequestsServlet");
    		//RequestDispatcher dispatch = request.getRequestDispatcher("ShowPendingRequestsServlet");
    		//dispatch.include(request, response);
    	}
    	else
    	{
    		out.println("<center><h5>Not Approved</h5></center>");
    		response.setHeader("refresh","3;URL = ShowPendingRequestsServlet");
//    		RequestDispatcher dispatch = request.getRequestDispatcher("ShowPendingRequestsServlet");
//    		dispatch.include(request, response);
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
