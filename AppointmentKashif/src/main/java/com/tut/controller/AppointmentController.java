package com.tut.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tut.dto.DoctorDTO;
import com.tut.feign.DoctorFeignClientFallBack;
import com.tut.feign.IDoctorFeignClient;
import com.tut.model.Appointment;
import com.tut.service.IAppointmentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class AppointmentController {
	
	@Autowired
	IAppointmentService appoService;
	
	@Autowired
	IDoctorFeignClient  doctorFeignClient;
	
	@Autowired
	DoctorFeignClientFallBack doctorFeignClientFallBack;

	@GetMapping("/allappointments")
	public List<Appointment> getAppointment(){
		return appoService.getAllAppointment();
	}
	
	
	@PostMapping("/addappointment")
	public Appointment addAppointment(@RequestBody Appointment appo) 
	{
		return appoService.addAppointment(appo);
	}
	
	
	@PutMapping("updateappointment/{id}")
	public Appointment updateApp(@PathVariable int id, @RequestBody Appointment entity) {
		return appoService.updateApp(id,entity);
	}
	
	@DeleteMapping("/deleteappo/{id}")
	public void deleteAppointmentById(@PathVariable int id) {
		 appoService.deleteAppointmentById(id);
	}
	
	
	/*
	 Circuit Breaker is used for handling The situation in which other services are not working
	 here we are handling if docAditi service is not started or working 
	 then for user experience it is handed by class DoctorDetailsFallback and 
	 Annotation @CircuitBreaker @Retry
	 */
	@GetMapping("/getdocsfeign/{id}")
	@CircuitBreaker(name = "crctbrkr", fallbackMethod = "getDoctorDetailsFallback")
	@Retry(name = "crctbrkr" , fallbackMethod = "getDoctorDetailsFallback")
	public Optional<DoctorDTO> getDoctorDetails(@PathVariable int id) 
	{
			return doctorFeignClient.getDoctorById(id);
	}
	
	
	public Optional<DoctorDTO> getDoctorDetailsFallback(@PathVariable int id) 
	{
			return doctorFeignClientFallBack.getDoctorById(id);
	}
	
	
}
