package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.model.Appointment;
import com.example.demo.model.User;
import com.example.demo.web.dto.AppointmentDto;
import com.example.demo.web.dto.PrescriptionDto;
import com.example.demo.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
    void save(UserRegistrationDto registrationDto);
	void save(AppointmentDto appointmentDto);
	void save(PrescriptionDto prescriptionDto);
	User LoadDoctor(String email,String password);
	List<Appointment> findAllPatient(String name);
}
