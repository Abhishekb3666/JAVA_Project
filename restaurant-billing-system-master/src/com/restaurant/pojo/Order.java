package com.restaurant.pojo;

public class Order
{
    private int orderId,foodId,quantity;
    private String date,customerName;
    private double price;
     
    public Order()
    {
    	
    }

	public Order(int foodId, int quantity, String date, String customerName, double price) {
		super();
		this.foodId = foodId;
		this.quantity = quantity;
		this.date = date;
		this.customerName = customerName;
		this.price = price;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	public int getFoodId() {
		return foodId;
	}



	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
    
}
