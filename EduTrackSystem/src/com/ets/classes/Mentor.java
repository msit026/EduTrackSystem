package com.ets.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mentor {

	public Mentor()
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
			String query="select md_status from ets_mentor_details where md_mentor_id = '" + username + "' and md_password = '" + password + "' "; // query for the database
			rs=s.executeQuery(query);
			
			while(rs.next())
			{
				if(rs.getString("md_status").equalsIgnoreCase("a"))
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
