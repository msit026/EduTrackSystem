package com.ets.classes;

import java.sql.*;
public class MySQLCon
{
	public static Connection connectToDB()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://10.10.10.165/ets", "ets","ets");//insert the db name
		}
		catch(Exception e)
		{
			throw new Error(e);
		}
	}
	
	public static boolean closeConnection(Connection c)
	{
		try
		{
			c.close();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
