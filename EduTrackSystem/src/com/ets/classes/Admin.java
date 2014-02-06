package com.ets.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Mani
 * 
 */

public class Admin {
	private Connection con;
	private String query;
	private Statement st;
	private ResultSet rs;
	String admin_username = "admin";
	String admin_password = "admin";

	public Admin() {
		con = MySQLCon.connectToDB();
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Mano
	 * 
	 * Change the password of the Admin
	 */
	public boolean changePassword(String password)
	{
		admin_password = password;
		return true;
	}

	/**
	 * Author Mano
	 * 
	 * It Returns the Pending Requests of the students
	 * 
	 * @return
	 */
	public ResultSet getStudentPendingRequests() {
		try {
			query = "select * from ets_student_details where sd_status = 'p';";

			rs = st.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * Author Mano
	 * 
	 * It Approves the selected users
	 * 
	 * @param selectedStudents
	 * @return
	 */
	public boolean ApproveStudetns(String[] selectedStudents) {
		boolean flag = false;
		try {
			for (int i = 0; i < selectedStudents.length; i++) {
				query = "update ets_student_details set sd_status = 'a' where sd_student_id = '"
						+ selectedStudents[i] + "'";
				st.executeUpdate(query);
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean isValidUser(String username, String password) {
		if (username.equals(admin_username) && password.equals(admin_password)) {
			return true; // if the user is admin return 1
		}
		return false; // if nothing matches
	}

}
