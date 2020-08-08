package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Appointment;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.Doctorcheck;

@Controller
public class DoctorViewController {
	@Autowired
    private UserService userService;
	@GetMapping("/Doctorhome")
	public String show()
	{
		return "Doctorhome";
	}
	 @ModelAttribute("doctorview")
	 	public Doctorcheck DoctorDto() {
	 		return new Doctorcheck();
	 	}
	 @PostMapping("/Doctorview")
	    public String index(@ModelAttribute("doctorview") Doctorcheck accono,Model md){
		 List<Appointment> Doctorviews=userService.findAllPatient(accono.getUsername());
	md.addAttribute("Doctorview",Doctorviews);

	        return "Doctorview";
	    }
}
