package com.ets.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mentor {

	private Connection con;
	private String query;
	private Statement st;
	private ResultSet rs;

	public Mentor()// For the Purpose of the database connection
	{
		con = MySQLCon.connectToDB();
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isValidUser(String username, String password) {

		try {
			String query = "select md_status from ets_mentor_details where md_mentor_id = '"
					+ username + "' and md_password = '" + password + "' "; // query
																			// for
																			// the
																			// database
			rs = st.executeQuery(query);

			while (rs.next()) {
				if (rs.getString("md_status").equalsIgnoreCase("a")) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return false; // if nothing matches
	}

	/**
	 * Author Mano
	 *  
	 * It Returns the Courses of all the years
	 * @return
	 */
	public ResultSet showCourses()// Returns courses resultset
	{
		try {
			query = "select * from ets_course_details;";
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Author Mano
	 * 
	 * It Returns the Grades of the given Student
	 * @param studentId
	 * @return
	 */
	public ResultSet getGrades(String studentId)// Returns grades of the student
	{
		try {

			query = "select scd.scd_student_id,sd.sd_name,cd.cd_name,scd.scd_grades from ets_student_course_details scd,ets_student_details sd,ets_course_details cd where scd.scd_student_id = '"
					+ studentId
					+ "' and "
					+ "scd.scd_student_id = sd.sd_student_id"
					+ " and "
					+ "scd.scd_course_id = cd_course_id;";
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
