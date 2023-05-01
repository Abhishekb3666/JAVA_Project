package com.restaurant.dao;

import com.restaurant.pojo.Admin;

public interface AdminDao
{
	    boolean addAdmin(Admin a);
	    Admin getAdmin(String username,String password);
}
