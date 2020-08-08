package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.Doctor;

@Controller
public class Doctorcontroller {
	@Autowired
	private UserService userService;

	@GetMapping("/doctorLogin")
	public String showLogin() {
		return "doctorlogin";
	}
	@ModelAttribute("doctor")
    public Doctor userRegistrationDto() {
        return new Doctor();
    }
	@PostMapping("/Doctorhomes")
	public String LoginAccount(@ModelAttribute("doctor") Doctor dco) {
		User use=userService.LoadDoctor(dco.getUsername(),dco.getPassword());
		if(use==null)
			return "doctorlogin";
		return "index2";
	}
}
