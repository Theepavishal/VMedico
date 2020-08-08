package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.model.Prescription;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.AppointmentDto;
import com.example.demo.web.dto.PrescriptionDto;
import com.example.demo.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public void save(UserRegistrationDto registrationDto) {
		if(registrationDto.getRoles().compareTo("Patient")==0)
		{
			User user = new User(registrationDto.getFirstName(), 
					registrationDto.getLastName(), registrationDto.getEmail(),
					passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
			 userRepository.save(user);
		}
		else
		{
			User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_DOCTOR")));
		 userRepository.save(user);
		}
		
	}
	@Override
	public void save(AppointmentDto appointmentDto) {
		Appointment appointment =new Appointment(appointmentDto.getSpecialization(), appointmentDto.getDoctorname(), appointmentDto.getName(), appointmentDto.getGender(), appointmentDto.getNumber(), appointmentDto.getEmail(), appointmentDto.getDate());
		appointmentRepository.save(appointment);
	}
	
	@Override
	public void save(PrescriptionDto prescriptionDto) {
		Prescription prescription =new Prescription(prescriptionDto.getDoctorname(), prescriptionDto.getPatientid(), prescriptionDto.getMedicine(), prescriptionDto.getDosage(), prescriptionDto.getDiagnosis(), prescriptionDto.getAdditional());
		prescriptionRepository.save(prescription);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	//@Override
	//public UserDetails loadUserByUsername1(String username) throws UsernameNotFoundException {
		//Doctor doc = docrepo.findByEmail(username);
		//if(doc == null) {
			//throw new UsernameNotFoundException("Invalid username or password.");
		//}
		//return new org.springframework.security.core.userdetails.User(doc.getEmail(), doc.getPassword(), mapRolesToAuthorities(doc.getRoles()));		
	//}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public User LoadDoctor(String username,String password)  {
		User user=userRepository.findByEmail(username);
		return user;
	}
	@Override
	public List<Appointment> findAllPatient(String docname)
	{
		List<Appointment> list=appointmentRepository.findBydoctorname(docname);
		return list;
	}
	
}