package com.ets.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
	
	public Student()
	{
		Connection c=MySQLCon.connectToDB();
		try 
		{
			s=c.createStatement();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	Statement s=null;
	ResultSet rs=null;
	
	
	public boolean isValidUser(String username, String password)
	{
				
		try 
		{
			String query="select sd_status from ets_student_details where sd_student_id = '" + username + "' and sd_password = '" + password + "' "; // query for the database
			rs=s.executeQuery(query);
			
			while(rs.next())
			{
				if(rs.getString("sd_status").equalsIgnoreCase("a"))
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
			
		
		return false; // if nothing matches
	}
}
