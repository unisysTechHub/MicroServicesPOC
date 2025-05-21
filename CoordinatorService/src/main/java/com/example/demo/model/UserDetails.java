package com.example.demo.model;

import java.util.List;


public class UserDetails {
public UserDetails() {
    	
    }
    public UserDetails(String userId) {
    	this.userId = userId;
    }
	
	int id;
	String userId;
	String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
