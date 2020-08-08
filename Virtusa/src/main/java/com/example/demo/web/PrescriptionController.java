package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;
import com.example.demo.web.dto.PrescriptionDto;

@Controller  
@RequestMapping("/prescription")
public class PrescriptionController {
	
	private UserService userService;
	
	public PrescriptionController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("prescriptions")
    public PrescriptionDto prescriptionDto() {
        return new PrescriptionDto();
    }
	
	@GetMapping
	public String showPrescriptionForm() {
		return "prescription";
	}
	
	@PostMapping
	public String bookAppointment(@ModelAttribute("prescriptions") PrescriptionDto prescriptionDto) {
		userService.save(prescriptionDto);
		return "redirect:/prescription?success";
	}
}
