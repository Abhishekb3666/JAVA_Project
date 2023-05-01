package com.restaurant.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility 
{
	public static Connection connection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodorder","root","Abhishek@9141");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;	
	}
  
}
