package com.ets.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class passwordHelper 
{

	Statement s=null;
	ResultSet rs=null;
	String user=null;
	int flag=0; // to decide the role
	public passwordHelper() 
	{
		
		Connection c=(Connection) MySQLCon.connectToDB();
		try {
			s=(Statement) c.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		////establish databases connection and verify the email.
	}
	
	public int findUser(String userMail)
	{
		try 
		{
			String query="select * from ets_student_details;";
			rs=s.executeQuery(query);
			while(rs.next())
			{
				if(rs.getString(3).equals(userMail))
				{
					user=rs.getString(1);
					flag=1;
					return flag;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
		
		try 
		{
			String query="select * from ets_mentor_details;";
			rs=s.executeQuery(query);
			while(rs.next())
			{
				if(rs.getString(3).equals(userMail))
				{
					user=rs.getString(1);
					flag=2;
					return flag;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e);
		}
		return 0;
	}
	
	public void saveStudentPassword(String password, String email)
	{
		String query="update ets_student_details set sd_password=\""+password+"\" where sd_email=\""+email+"\";";
		System.out.println(query);
		try
		{
			s.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void saveMentorPassword(String password, String email)
	{
		String query="update ets_mentor_details set md_password=\""+password+"\" where md_email=\""+email+"\";";
		
		try
		{
			s.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
