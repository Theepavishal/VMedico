package com.example.demo.web.dto;

public class Doctor {
 String username;
 String password;
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
public Doctor(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public Doctor() {
	super();
}
 
}
