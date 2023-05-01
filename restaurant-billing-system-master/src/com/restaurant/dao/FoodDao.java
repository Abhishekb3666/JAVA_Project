package com.restaurant.dao;


import java.util.List;

import com.restaurant.pojo.Food;



public interface FoodDao 
{
	boolean addFood(Food f);
	boolean updateFood(Food f);
	boolean deleteFoodById(int FoodId);
	Food getFoodById(int FoodId);
	List<Food> getAllFood();
	List<Food> getFoodByCategory(String FoodCategory);
	String getFoodNameById(int foodId);

}

