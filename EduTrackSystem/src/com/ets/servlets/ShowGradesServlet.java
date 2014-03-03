package com.ets.servlets;

/**
 * @author Mani
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.Mentor;

/**
 * Servlet implementation class ShowGradesServlet
 */
public class ShowGradesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowGradesServlet() {
		super();
	}

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Mentor mentor = new Mentor();
		String studentId = request.getParameter("studentId");

		//request.setAttribute("showGrades", mentor.getGrades(studentId));
		ResultSet rs = mentor.getGrades(studentId);
		PrintWriter out = response.getWriter();
		out.println("<table>"
		+ "<tr>"
		+ "<th>Id</th>"
		+	"<th>Name</th>"
		+	"<th>Course Name</th>"
		+	"<th>Grades</th>"
		+ "</tr>");
		try {
			while(rs.next())
			{
				out.println("<tr>"
					+	"<td>" + rs.getString("scd_student_id") + "</td>"
					+	"<td>" + rs.getString("sd_name") + "</td>"
					+	"<td>" + rs.getString("cd_name") + "</td>"
					+	"<td>" + rs.getString("scd_grade") + "</td>"
					+ "</tr>");
				
			}
			out.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
