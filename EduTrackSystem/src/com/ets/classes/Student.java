package com.ets.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {

	private Connection con;
	private String query;
	private Statement st;
	private ResultSet rs;

	public Student() {
		con = MySQLCon.connectToDB();
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isValidUser(String username, String password) {
		try {
			String query = "select sd_status from ets_student_details where sd_student_id = '"
					+ username + "' and sd_password = '" + password + "' "; // query
																			// for
																			// the
																			// database
			rs = st.executeQuery(query);
			while (rs.next()) {
				if (rs.getString("sd_status").equalsIgnoreCase("a")) {
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
	 * It Returns the registered Students list
	 * @return
	 */
	public ResultSet getRegisteredStudentsList() {
		try {
			query = "select * from ets_student_details where sd_status = 'a'";
			rs = st.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Author Mano
	 * 
	 * It Returns the UnRegistered Students List
	 * @return
	 */
	public ResultSet getUnRegisteredStudents()
	{
		try {
			query = "select * from ets_student_details where sd_status = 'p'";
			rs = st.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void getStudentDetails(String path)
	{}
}
