package com.ets.servlets;

/**

 * Inserts the student and mentor details after registration

 *@author <Ujvala B>

 *@version <java "1.7.0_45">

 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ets.classes.MySQLCon;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Registration
 */
public class Registrations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registrations() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("checking...");
			String role = request.getParameter("role");
			String ID = request.getParameter("ID");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String address = request.getParameter("address");

			String dob = request.getParameter("dob");
			String gender = request.getParameter("gender");
			if (gender.equalsIgnoreCase("male")) {
				gender = "m";
			} else {
				gender = "f";
			}
			
			String mobileno = request.getParameter("mobileno");
			String name = null;
			String emailId = request.getParameter("emailId");
			String password = request.getParameter("password");
			String designation = request.getParameter("department");
			String year = request.getParameter("currentYear");
			Connection con = MySQLCon.connectToDB();
			PreparedStatement preparedStatement = null;
			Statement stmt = (Statement) con.createStatement();
			String flag = "p";
			System.out.println("checking 2...");
			if (role.equalsIgnoreCase("Mentor")) {
				System.out.println("mentor");
				String query = "select * from ets_mentor_details where md_mentor_id = '"
						+ ID + "' and md_status != 'p' and md_status != 'a'";
				System.out.println(query);
				ResultSet rs = stmt.executeQuery(query);

				if (rs.next()) {
					System.out.println("In if of registations!!");
					String str = "UPDATE  ets_mentor_details set  md_email='"
							+ emailId + "',md_password='" + password
							+ "',md_dob='" + dob + "',md_phone='" + mobileno
							+ "',md_address='" + address + "',md_gender='"
							+ gender + "',md_department'" + designation
							+ "',md_status='a' where md_mentor_id='" + ID
							+ "' ;";
					System.out.println(str);
					int value = stmt.executeUpdate(str);
					if (value > 0) {
						System.out
								.println("Inserted mentor details Successfully....");
						request.setAttribute("isSuccess", "true");
					} else {
						System.out
								.println("Problem in mentor details Insertion....");
						request.setAttribute("isSuccess", "false");
						response.setContentType("text/html");
						RequestDispatcher rd = request.getRequestDispatcher("RegistrationSuccessPage.jsp");
						rd.include(request, response);
					}
				} else {
					System.out.println("hello");
					PrintWriter out = response.getWriter();
					out.println("<html><head><script type='text/javascript'>alert('You are already registered.please wait for the Admin approval');</script></head></html>");
				}
				response.setContentType("text/html");
				RequestDispatcher rd = request.getRequestDispatcher("homePage.html");
				rd.include(request, response);
			}
				

				if (role.equalsIgnoreCase("Student")) {
					System.out.println("student");
					String query1 = "select * from ets_student_details where sd_student_id = '"
							+ ID + "' and sd_status != 'p' and sd_status !='a'";
					System.out.println(query1);
					ResultSet rs1 = stmt.executeQuery(query1);
					if (rs1.next()) {
						System.out.println("Noooo");
						String str = "UPDATE ets_student_details set sd_email='"
								+ emailId
								+ "',sd_password='"
								+ password
								+ "',sd_dob='"
								+ dob
								+ "',sd_phone='"
								+ mobileno
								+ "',sd_address='"
								+ address
								+ "',sd_gender='"
								+ gender
								+ "',sd_status='"
								+ flag
								+ "',sd_year_in_course='"
								+ year
								+ "', sd_admitted_year = '"
								+ year
								+ "'  where sd_student_id='" + ID + "' ;";
						System.out.println(str);
						int value = stmt.executeUpdate(str);
						System.out.println(str);
						if (value > 0) {
							System.out
									.println("Inserted mentor details Successfully....");
							request.setAttribute("isSuccess", "true");
						} else {
							System.out
									.println("Problem in mentor details Insertion....");
							request.setAttribute("isSuccess", "false");
							response.setContentType("text/html");
							RequestDispatcher rd = request.getRequestDispatcher("RegistrationSuccessPage.jsp");
							rd.include(request, response);
						}
					} else {
						System.out.println("yes!!");
						PrintWriter out = response.getWriter();
						out.println("<html><head><script type='text/javascript'>alert('You are already registered.please wait for the Admin approval');</script></head></html>");
					}
					response.setContentType("text/html");
					RequestDispatcher rd = request.getRequestDispatcher("homePage.html");
					rd.include(request, response);
					//response.sendRedirect("RegistrationSuccessPage.jsp");

				}

		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
