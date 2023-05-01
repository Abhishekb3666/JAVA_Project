package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restaurant.pojo.Admin;
import com.restaurant.utility.DBUtility;


public class AdminDaoImp implements AdminDao
{
	String str;
	PreparedStatement stmt;
	ResultSet rs;
	int row=0;
	Admin a;
	static Connection con=DBUtility.connection();
	
	@Override
	public boolean addAdmin(Admin a) 
	{
		str="insert into admin(adminName,username,phone,address,password) values(?,?,?,?,?)";
    	try
    	{
    	stmt=con.prepareStatement(str);
    	stmt.setString(1,a.getAdminName());
    	stmt.setString(2,a.getUsername());
    	stmt.setString(3,a.getPhone());
    	stmt.setString(4,a.getAddress());
    	stmt.setString(5,a.getPassword());
    	
    	row=stmt.executeUpdate();   //return type of executeupdate is int, it returns ROWS affected in DATABASE
    	
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	if(row>0)
    		return true;
    	else
    		return false;
		
	}


	@Override
	public Admin getAdmin(String username, String password) 
	{
		str="select * from Admin where username=? and password=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1,username);
			stmt.setString(2,password);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				a = new Admin(rs.getString("adminName"),rs.getString("phone"),rs.getString("username"),rs.getString("password"),rs.getString("address"));
				a.setAdminId(rs.getInt("adminId"));
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return a;
	}

}
