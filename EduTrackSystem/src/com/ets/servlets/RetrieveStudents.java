package com.ets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ets.classes.Student;

/**
 * Servlet implementation class RetrieveStudents
 */
public class RetrieveStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveStudents() {
		super();
	}

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		try {
			if (session.getAttribute("userId") == null && session.getAttribute("uname") == null ) {
				response.sendRedirect("logout");
			} else {

				String year = request.getParameter("cYear");
				Student student = new Student();
				ResultSet rs = student.getSelectedYearStudents(year);
				System.out.println(year);
				System.out.println("--->"+rs);
				PrintWriter out = response.getWriter();

				out.println("<td>");
				out.println("<label for = 'Studentid' style='color:black ;font-size:12px'>Student Id : </label></td>"
						+ "<td>");
				if (request.getParameter("grades") != null) {
					out.println("<select name='studentsList' id = 'studentsList' onchange='showGrades()'>");
				} else if (request.getParameter("prediction") != null)// for the
																		// purpose
																		// of
																		// prediction
																		// tool
					out.println("<select name='studentsList' id = 'studentsList' onchange='showCGPA()'>");
				else
					// for the purpose of feedback tool
					out.println("<select name='studentsList' id = 'studentsList'>");
				
				out.println("<option value='select'>Select</option>");
				try {
					while (rs.next()) {
						System.out.println("inside");
						out.println("<option value="
								+ rs.getString("sd_student_id") + ">"
								+ rs.getString("sd_student_id") + "</option>");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				out.println("</select></td>");
			}
		} catch (Exception e) {
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
