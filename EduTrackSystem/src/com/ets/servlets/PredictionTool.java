package com.ets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.MySQLCon;
import com.ets.classes.Student;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class PredictionTool
 */
public class PredictionTool extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PredictionTool() {
		super();
		con = (Connection) MySQLCon.connectToDB();
	}

	public void predictRollNo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String batch = (String) request.getParameter("cYear");
		Student student = new Student();
		ResultSet rs = student.getSelectedYearStudents(batch);

		PrintWriter out = response.getWriter();

		out.println("<td>");
		out.println("<label for = 'Studentid'>Student Id : </label></td>"
				+ "<td>");
		out.println("<select name='studentsList' id = 'studentsList' >");

		try {
			while (rs.next()) {

				out.println("<option value=" + rs.getString("sd_student_id")
						+ ">" + rs.getString("sd_student_id") + "</option>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</select></td>");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		predictRollNo(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		predictRollNo(request, response);
	}

}
