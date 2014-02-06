package com.ets.servlets;

/**
 * @author Mani
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.Admin;
/**
 * Servlet implementation class ApproveRequests
 */
public class ShowPendingRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Admin admin;
    /**
     * Default constructor. 
     */
    public ShowPendingRequestsServlet() {
    }

    /**
     * Processes the Request
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	admin = new Admin();
    	
    	request.setAttribute("studentRequests", admin.getStudentPendingRequests());
    
    	RequestDispatcher dispatcher = request.getRequestDispatcher("ShowPendingRequests.jsp");
    	dispatcher.forward(request, response);
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
