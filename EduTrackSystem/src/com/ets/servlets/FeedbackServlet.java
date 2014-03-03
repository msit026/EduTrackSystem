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

import com.ets.classes.Mentor;

/**
 * Servlet implementation class FeedbackServlet
 */
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
    }

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("year");
		String studentId = request.getParameter("studentsList");
		String title = request.getParameter("title");
		String description = request.getParameter("feedback");
		HttpSession session = request.getSession();
		ResultSet rsSession = (ResultSet)session.getAttribute("userDetails");
		
		try {
			if(rsSession.next())
			{
				String mentorName = rsSession.getString("md_name");
				Mentor mentor = new Mentor();
				mentor.addFeedback(mentorName,year,studentId,title,description);
				PrintWriter out=response.getWriter();
				out.println("<html><head><script>alert('Submitted feedback successfully');</script></head></html>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("MentorHomePage.jsp");
				dispatcher.include(request, response);
			}
			else
			{
				response.sendRedirect("logout.html");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

}
