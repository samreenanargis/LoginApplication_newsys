package com.ikigai.user_app.bean;

public class LoginBean {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		System.out.println("LoginBean setUsername START");
		this.username = username;
		System.out.println("username: " + username);
		System.out.println("LoginBean setUsername END");

	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("LoginBean setPassword START");
		this.password = password;
		System.out.println("password: " + password);
		System.out.println("LoginBean setPassword END");


	}
	

}
