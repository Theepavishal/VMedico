package com.example.demo.web.dto;

import java.sql.Date;

public class AppointmentDto {

	private String specialization;
	private String doctorname;
	private String name;
	private String gender;
	private Long number;
	private String email;
	private Date date;
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public AppointmentDto(String specialization, String doctorname, String name, String gender,  Long number, String email, Date date) {
		super();
		this.specialization = specialization;
		this.doctorname = doctorname;
		this.name = name;
		this.gender= gender;
		this.number = number;
		this.email = email;
		this.date = date;
	}
	public AppointmentDto() {
		// TODO Auto-generated constructor stub
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
}
