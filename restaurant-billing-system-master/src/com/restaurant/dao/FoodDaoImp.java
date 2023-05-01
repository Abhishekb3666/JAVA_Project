package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.pojo.Food;
import com.restaurant.utility.DBUtility;


public  class FoodDaoImp implements FoodDao
{
	String str;
	PreparedStatement stmt;
	ResultSet rs;
	int row=0;
	Food f;

    static Connection con=DBUtility.connection();
    
    public boolean addFood(Food f)
    {
    	str="insert into food(FoodName,FoodCategory,FoodDescription,Price) values(?,?,?,?)";
    	try
    	{
    	stmt=con.prepareStatement(str);
    	stmt.setString(1,f.getFoodName());
    	stmt.setString(2,f.getFoodCategory());
    	stmt.setString(3,f.getFoodDescription());
    	stmt.setDouble(4,f.getPrice());
    	
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
	public boolean updateFood(Food f) 
	{
		str="update Food set FoodName=?,FoodCategory=?,FoodDescription=?,Price=? where FoodId=?";
    	try
    	{
    	stmt=con.prepareStatement(str);
    	stmt.setString(1,f.getFoodName());
    	stmt.setString(2,f.getFoodCategory());
    	stmt.setString(3,f.getFoodDescription());
    	stmt.setDouble(4,f.getPrice());
    	stmt.setInt(5,f.getFoodId());
    	
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
	public boolean deleteFoodById(int FoodId) 
	{
        str="delete from Food where FoodId=?";
        try
      	{
      	stmt=con.prepareStatement(str);
      	stmt.setInt(1,FoodId);
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
	public Food getFoodById(int FoodId)
	{
		str="select * from Food where FoodId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1, FoodId);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				f= new Food();
				f.setFoodId(rs.getInt("FoodId"));
				f.setFoodName(rs.getString("FoodName"));
				f.setFoodCategory(rs.getString("FoodCategory"));		
				f.setFoodDescription(rs.getString("FoodDescription"));
		        f.setPrice(rs.getDouble("Price"));	
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return f;

	}

	@Override
	public List<Food> getAllFood()
	{
		str="select * from Food";
		List<Food> li=new ArrayList<>();
		try
		{
			stmt=con.prepareStatement(str);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				f= new Food();
				f.setFoodId(rs.getInt("FoodId"));
				f.setFoodName(rs.getString("FoodName"));
				f.setFoodCategory(rs.getString("FoodCategory"));
				f.setFoodDescription(rs.getString("FoodDescription"));
		        f.setPrice(rs.getDouble("Price"));
		        li.add(f);
		        
				
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return li;

		
	}

	@Override
	public List<Food> getFoodByCategory(String FoodCategory)
	{
		str="select * from Food where FoodCategory=?";
		List<Food> li=new ArrayList<>();
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1,FoodCategory);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				f= new Food();
				f.setFoodId(rs.getInt("FoodId"));
				f.setFoodName(rs.getString("FoodName"));
				f.setFoodCategory(rs.getString("FoodCategory"));
				f.setFoodDescription(rs.getString("FoodDescription"));
		        f.setPrice(rs.getDouble("Price"));
		        li.add(f);
		        //We can also set this values of Object Food by using Food Constructor
				
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return li;

		
	}

	@Override
	public String getFoodNameById(int foodId)
	{
		String foodName=null;
		str="select FoodName from Food where FoodId=?";
		List<Food> li=new ArrayList<>();
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1,foodId);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				foodName=rs.getString("FoodName");
			}
		}
		
		catch(SQLException e)
      	{
      		e.printStackTrace();
      	}
		
		return foodName;
	}		
}
