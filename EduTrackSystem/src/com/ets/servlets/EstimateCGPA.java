package com.ets.servlets;

/**
 * @author Ujvala
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.Course;

/**
 * Servlet implementation class EstimateCGPA
 */
public class EstimateCGPA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EstimateCGPA() {
		super();
	}

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Double[] marks = new Double[20];
		
		marks[0] = Double.parseDouble(request.getParameter("Preparatory"));
		marks[1] = Double.parseDouble(request.getParameter("OOPS"));
		marks[2] = Double.parseDouble(request.getParameter("DataStructures"));
		marks[3] = Double.parseDouble(request.getParameter("Algorithms"));
		marks[4] = Double.parseDouble(request.getParameter("Database"));
		marks[5] = Double.parseDouble(request.getParameter("Software"));
		marks[6] = Double.parseDouble(request.getParameter("Web"));
		marks[7] = Double.parseDouble(request.getParameter("Computer"));
		marks[8] = Double.parseDouble(request.getParameter("Advanced"));
		marks[9] = Double.parseDouble(request.getParameter("Practicum"));
		marks[10] = Double.parseDouble(request.getParameter("Softskills-1"));
		marks[11] = Double.parseDouble(request.getParameter("Software"));
		marks[12] = Double.parseDouble(request.getParameter("Specialization"));
		marks[13] = Double.parseDouble(request.getParameter("Internship"));
		marks[14] = Double.parseDouble(request.getParameter("Softskills-2"));

		PrintWriter out = response.getWriter();
		Course course = new Course();
		ResultSet rs = course.getCourseDetails();
		
		double total_marks = 0, cgpa;
		double credits = 0.0, total_credits = 0;
		
		int i = 0;
		try {
			while (rs.next()) {

				credits = rs.getInt("cd_credits");
				if (marks[i] > 0.0) {
					total_marks += marks[i] * credits;
					total_credits += credits;
				}
				i++;
			}
			cgpa = total_marks / total_credits;
			NumberFormat df = NumberFormat.getNumberInstance(); 
			out.print("<html><script>alert('Estimated CGPA is : " + df.format(cgpa) + "');</script></html>");
			
			RequestDispatcher dispatch = request.getRequestDispatcher("PredictionTool.jsp");
			dispatch.include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
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
