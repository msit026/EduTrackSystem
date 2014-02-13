package com.ets.servlets;

/**
 * @author Ujvala
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.Course;
import com.ets.classes.Student;

/**
 * Servlet implementation class RetrieveCGPA
 */
public class RetrieveCGPA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrieveCGPA() {
		super();
	}

	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// HttpSession session = request.getSession();
		// ResultSet rsSession = (ResultSet) session.getAttribute("userDetails")
		// ;
		// try {
		// if (rs.next()) {
		// response.sendRedirect("logout");
		// } else {
		int completed_courses = 0;
		String studentNo = request.getParameter("studentNo");
		Student student = new Student();
		ResultSet rs = student.getSelectedCGPA(studentNo);

		PrintWriter out = response.getWriter();

		out.println("<table style=width: 378px; height: 83px;><tr><td>");
		out.println("<label for = 'cgpa'>CGPA so far : </label></td>" + "<td>");
		// out.println("<select name='studentsList' id = 'studentsList' onchange=showCGPA() >");
		double marks = 0.0, total_marks = 0, cgpa;
		double credits = 0.0, total_credits = 0;
		try {
			while (rs.next()) {
				marks = rs.getInt("scd_total");
				credits = rs.getInt("cd_credits");
				total_marks += marks * credits;
				total_credits += credits;
			}
			cgpa = total_marks / total_credits;
			out.println("<form action=EstimateCGPA method=get><input type=text id=cgpa value="
					+ cgpa + ">" + "</td></tr></table>");

			rs.beforeFirst();
			out.println("<hr><center><table>");
			while (rs.next()) {
				out.println("<tr > <td> " + rs.getString("cd_name")
						+ ":</td><td><input type=text id="
						+ rs.getString("cd_name") + " name="
						+ rs.getString("cd_name") + " value= "
						+ rs.getInt("scd_total") + "></td></tr>");
				completed_courses++;
			}
			Course course = new Course();

			ResultSet rs1 = course.getCourseDetails();

			rs1.absolute(completed_courses);
			while (rs1.next()) {
				out.println("<tr > <td> " + rs1.getString("cd_name")
						+ ":</td><td><input type=text id="
						+ rs1.getString("cd_name") + " name="
						+ rs1.getString("cd_name") +" value=0.0 ></td></tr>");
			}
			out.println("<tr><td colspan=2> <center><Input type=submit value=Estimate CGPA ></tr></table></center></center><form>");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// }
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
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
