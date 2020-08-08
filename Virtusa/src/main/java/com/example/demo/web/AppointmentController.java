package com.example.demo.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;
import com.example.demo.web.dto.AppointmentDto;  
@Controller  
@RequestMapping("/appointment")
public class AppointmentController {
	
	private UserService userService;
	  
	
	public AppointmentController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("appointment")
    public AppointmentDto appointmentDto() {
        return new AppointmentDto();
    }
	
	@GetMapping
	public String showAppointmentForm() {
		return "appointment";
	}
	
	@PostMapping
	public String bookAppointment(@ModelAttribute("appointment") AppointmentDto appointmentDto) {
		userService.save(appointmentDto);
		return "redirect:/appointment?success";
	}
}
