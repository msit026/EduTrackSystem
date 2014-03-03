package com.ets.servlets;

/**
 * @author Mani
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.Student;

/**
 * Servlet implementation class ShowStudentsServlet
 */
public class ShowUnRegisteredStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowUnRegisteredStudentsServlet() {
		super();
	}

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("cYear") != null)
		{
			System.out.println("In if");
			Student student = new Student();
			ResultSet rs = student.getUnRegisteredStudents(request.getParameter("cYear").toString());
			PrintWriter out = response.getWriter();
			try {
				out.println("<table>"
						 + "<tr>"
							+ "<td>Roll No</td>"
							+ "<td>Name</td>"
							+ "<td>Year</td>");
				while(rs.next())
				{
					 
					out.println("</tr><tr><td>" + rs.getString("sd_student_id") + "</td><td>" + rs.getString("sd_name")+ "</td><td>" + rs.getString("sd_year_in_course") + "</td></tr>");
				}
				out.println("</table>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
