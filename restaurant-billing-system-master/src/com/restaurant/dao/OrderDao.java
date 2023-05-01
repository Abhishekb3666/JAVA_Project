package com.restaurant.dao;

import java.util.List;

import com.restaurant.pojo.Order;

public interface OrderDao 
{
	public boolean addOrder(Order order);
    public List<Order> getAllOrder();
    public double totalOrderPrice(String customerName);
}
