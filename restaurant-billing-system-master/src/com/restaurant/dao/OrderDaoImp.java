package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.pojo.Order;
import com.restaurant.utility.DBUtility;


public class OrderDaoImp implements OrderDao
{
	PreparedStatement stmt;
    ResultSet rs;
    int row=0,count=0;

	@Override
	public boolean addOrder(Order order) 
	{
        Connection con=DBUtility.connection();
		
		String query="insert into Orders(customerName,foodId,quantity,price,date) Values(?,?,?,?,?)";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1,order.getCustomerName());
			stmt.setInt(2,order.getFoodId());
			stmt.setInt(3,order.getQuantity());
			stmt.setDouble(4,order.getPrice());
			stmt.setString(5,order.getDate());
		    row=stmt.executeUpdate();
		} 
		catch (SQLException e)
		{	
			e.printStackTrace();
		}
		if(row>0)
			return true;
		else
			return false;
	}
	
	@Override
	public List<Order> getAllOrder() 
	{
		Connection con=DBUtility.connection();
		Statement stmt;
		String query="select * from orders";
		Order order = null ;
		List<Order> li=new ArrayList<>();
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			while(rs.next())
			{
				order=new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setCustomerName(rs.getString("customerName"));
				order.setFoodId(rs.getInt("foodId"));
				order.setQuantity(rs.getInt("quantity"));
				order.setPrice(rs.getDouble("price"));
				order.setDate(rs.getString("date"));
				li.add(order);  
		  	
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return li;
	}

	@Override
	public double totalOrderPrice(String customerName)
	{	
		Connection con=DBUtility.connection();
		Statement stmt;
		double price=0;
		String query="select price from orders where customerName='"+customerName+"'";
		
		try
		{
			stmt=con.createStatement();
			rs=stmt.executeQuery(query); 
			
			while(rs.next())
			{
				double p=rs.getDouble("price");
				price=price+p;
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}

		return price;
	}

	

}
