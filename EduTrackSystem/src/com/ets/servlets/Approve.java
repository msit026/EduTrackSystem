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
import javax.servlet.http.HttpSession;

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
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Admin admin = new Admin();
		String[] selectedStudents = request.getParameterValues("checkedRows");
		String[] selectedMentors = request.getParameterValues("checkedRows");

		boolean flag = admin.ApproveStudetns(selectedStudents);

		boolean flag1 = admin.ApproveMentors(selectedMentors);
		if (flag || flag1) {
			request.setAttribute("approvalStatus", "APPROVED");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("StudentPendingRequests", admin.getNumberOfPendingStudentRequests());
			session.setAttribute("MentorPendingRequests", admin.getNumberOfPendingMentorRequests());
			
			RequestDispatcher dispatch = request
					.getRequestDispatcher("ApprovalStatusPage.jsp");
			dispatch.include(request, response);
		}

		else {

			request.setAttribute("approvalStatus", "NOT APPROVED");
			RequestDispatcher dispatch = request
					.getRequestDispatcher("ApprovalStatusPage.jsp");
			dispatch.include(request, response);

		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
