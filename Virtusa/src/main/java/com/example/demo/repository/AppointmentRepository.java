package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
    List<Appointment> findBydoctorname(String name);
}
