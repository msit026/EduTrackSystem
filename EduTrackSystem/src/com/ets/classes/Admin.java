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
	private String admin_username = "admin";
	private String admin_password = "admin";

	public Admin() {

		try {
			con = MySQLCon.connectToDB();
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	 * Author sneha
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
		if (username.equalsIgnoreCase(getAdmin_username()) && password.equals(getAdmin_password())) {
			return true; // if the user is admin return 1
		}
		return false; // if nothing matches
	}
	
	/**
	 * Author: Matha Harika
	 * This method adds courses to the approved student in student-course table
	 * @param string
	 */
	public boolean addCoursesToStudent(String studentID) 
	{
		try
		{
			query = "select sd_year_in_course from ets_student_details where sd_student_id = \"" + studentID + "\";";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			int course_year = rs.getInt("sd_year_in_course");
			query = "select cd_course_id from ets_course_details where cd_course_year = " + course_year + ";";
			rs = st.executeQuery(query);
			while(rs.next())
			{
				query = "insert into ets_student_course_details values('" + studentID + "', '" + rs.getString("cd_course_id") + "', 0, 'Z', " + course_year + ", 0)";
				st.executeUpdate(query);
				return true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public String getAdmin_username() {
		return admin_username;
	}

	/**
	 * @author Mani
	 * @return
	 */
	public String getAdmin_password() {
		return admin_password;
	}

	/**
	 * @author Mani
	 * @return
	 */
	public ResultSet getMentorPendingRequests() {
		try {
			query = "select * from ets_mentor_details where md_status = 'p';";

			rs = st.executeQuery(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
	
	/**
	 * @author Sneha
	 * @return
	 */
	public int getNumberOfPendingStudentRequests()
	{
		try {
			query = "select count(*) as count from ets_student_details where sd_status = 'p';";

			rs = st.executeQuery(query);
			rs.next();
			return rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * @author Sneha
	 * @return
	 */
	public int getNumberOfPendingMentorRequests()
	{
		try {
			query = "select count(*) as count from ets_mentor_details where md_status = 'p';";

			rs = st.executeQuery(query);
			rs.next();
			return rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * @author Sneha
	 * 
	 * It Approves the mentors
	 * @param selectedMentors
	 * @return
	 */
	public boolean ApproveMentors(String[] selectedMentors) {
		boolean flag = false;
		try {
			for (int i = 0; i < selectedMentors.length; i++) {
				query = "update ets_mentor_details set md_status = 'a' where md_mentor_id = '"
						+ selectedMentors[i] + "'";
				st.executeUpdate(query);
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
