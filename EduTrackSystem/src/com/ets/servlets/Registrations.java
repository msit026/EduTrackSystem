package com.ets.servlets;

/**

* Inserts the student and mentor details after registration

*@author <Ujvala B>

*@version <java "1.7.0_45">

*/

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String role=request.getParameter("role");
		System.out.println("Inserted Successfully...."+role);
		String ID=request.getParameter("ID");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String address=request.getParameter("address");
		
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		if(gender.equalsIgnoreCase("male"))
		{
			gender="m";
		}
		else
		{
			gender="f";
		}
		String mobileno=request.getParameter("mobileno");
		String name=null;
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		//String programme=request.getParameter("programme");
		String designation=request.getParameter("department");
		String year=request.getParameter("currentYear");
		//String year="2013";
		Connection con  = MySQLCon.connectToDB();
		PreparedStatement preparedStatement =null;
		Statement stmt = (Statement) con.createStatement();
		String flag="p";
		if(role.equalsIgnoreCase("Mentor"))
		{
			
			String str = "UPDATE  ets_mentor_details set  md_email='"+emailId +"',md_password='"+password+"',md_dob='"+dob+"',md_phone='"+mobileno+"',md_address='"+address+"',md_gender='"+ gender+"',md_department'"+ designation+"',md_status='"+ flag+"'where md_mentor_id='"+ ID+"' ;" ;
			System.out.println(str);
			int value = stmt.executeUpdate(str);
			//int value1 = stmt.executeUpdate(str1);
			
			//System.out.println("Inserted mentor Successfully...."+value);
			if(value > 0) 
			{
				System.out.println("Inserted mentor details Successfully....");
			}
			else 
			{
				System.out.println("Problem in mentor details Insertion....");
			}
		}
		if(role.equalsIgnoreCase("Student"))
		{
			

			String str = "UPDATE ets_student_details set sd_email='"+emailId +"',sd_password='"+password+"',sd_dob='"+dob+"',sd_phone='"+mobileno+"',sd_address='"+address+"',sd_gender='"+ gender+"',sd_status='"+ flag+"',sd_year_in_course='"+ year+"', sd_admitted_year = '"+year+"'  where sd_student_id='"+ ID+"' ;" ;
			//String str1 = "UPDATE TABLE ets_mentor_details set sd_admitted_year='"+ year+"'";
			System.out.println(str);
			int value = stmt.executeUpdate(str);
			System.out.println(str);
			//int value1 = stmt.executeUpdate(str1);
			
			//System.out.println("Inserted mentor Successfully...."+value);
			if(value > 0) 
			{
				System.out.println("Inserted mentor details Successfully....");
			}
			else 
			{
				System.out.println("Problem in mentor details Insertion....");
			}
		}
	        response.setContentType("text/html");
			response.sendRedirect("RegistrationSuccessPage.jsp");
	} catch (Exception e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
