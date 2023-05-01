package com.restaurant.pojo;

public class Food 
{
	private int FoodId;
	private String FoodName,FoodCategory,FoodDescription;  
	private double Price;
	
	public Food()
	{
		
	}
	
	public Food(String foodName, String foodCategory, String foodDescription,double price) 
	{
		super();
		FoodName = foodName;
		FoodCategory = foodCategory;
		FoodDescription = foodDescription;
		Price = price;
	}

	public int getFoodId() {
		return FoodId;
	}

	public void setFoodId(int foodId) {
		FoodId = foodId;
	}

	public String getFoodName() {
		return FoodName;
	}

	public void setFoodName(String foodName) {
		FoodName = foodName;
	}

	public String getFoodCategory() {
		return FoodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		FoodCategory = foodCategory;
	}

	

	public String getFoodDescription() {
		return FoodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		FoodDescription = foodDescription;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
}
