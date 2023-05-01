package com.restaurant.pojo;

public class Admin 
{
	private int adminId;
    private String adminName,phone,username,password,address;
    
    public Admin()
    {
    	
    }
    
	public Admin(String adminName, String phone, String username, String password, String address) {
		super();
		this.adminName = adminName;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
}
