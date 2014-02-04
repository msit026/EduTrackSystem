package com.ets.classes;

import java.sql.*;

/**
 * 
 * @author Mani
 *
 */
public class Admin {
	private Connection con;
	private String query;
	private MySQLCon connection;
	private Statement st;
	private ResultSet rs;
	String admin_username="admin";
	String admin_password="admin";
	
	public Admin()
	{
		con = MySQLCon.connectToDB();
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet getStudentPendingRequests()
	{
		try {
			query = "select * from ets_student_details where sd_status = 'p';";
			
			rs = st.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	public boolean ApproveStudetns(String[] selectedStudents)
	{
		boolean flag = false;
		try
		{
			for(int i = 0 ; i < selectedStudents.length ; i++)
			{
				query = "update ets_student_details set sd_status = 'a' where sd_student_id = '"+selectedStudents[i]+"'";
				st.executeUpdate(query);
				flag = true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
	}
public boolean isValidUser(String username, String password)
	{
	
		if(username.equals(admin_username)&&password.equals(admin_password))
		{
			return true;  // if the user is admin return 1
		}
		
		/*else
		{
			try 
			{
				String query="select * from credentials;"; // query for the database
				rs=s.executeQuery(query);
				
				while(rs.next())
				{
					if(rs.getString(3).equals(username)&&rs.getString(4).equals(password)) //search via indices
					{
						return 2; //if user is student similarly search for the mentor if they are in different tables....as i dont know the structure of the tables
					}
				}
			}
			catch(Exception e)
			{
				System.out.println("Error: "+e);
			}
			
		}*/
		
		return false; // if nothing matches
	}

}


