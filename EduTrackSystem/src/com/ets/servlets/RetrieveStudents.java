package com.ets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		//HttpSession session = request.getSession();
		//ResultSet rsSession = (ResultSet) session.getAttribute("userDetails") ; 
		//try {
			//if (rs.next()) {
				//response.sendRedirect("logout");
			//} else {
			
				String year = request.getParameter("cYear");
				Student student = new Student();
				ResultSet rs = student.getSelectedYearStudents(year);

				PrintWriter out = response.getWriter();

				out.println("<td>");
				out.println("<label for = 'Studentid'>Student Id : </label></td>"
						+ "<td>");
				if(request.getParameter("prediction") != null)//for the purpose of prediction tool
					out.println("<select name='studentsList' id = 'studentsList' onchange='showCGPA()'>");
				else//for the purpose of feedback tool
					out.println("<select name='studentsList' id = 'studentsList'>");

				try {
					while (rs.next()) {
						out.println("<option value="
								+ rs.getString("sd_student_id") + ">"
								+ rs.getString("sd_student_id") + "</option>");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				out.println("</select></td>");
			//}
		//} catch (SQLException e) {
			//e.printStackTrace();
		//}
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
