package com.tut.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tut.entity.Patient;
import com.tut.services.IPatientService;

//@RequestMapping("/api")
@RestController
public class PatientController {
	
	@Autowired
	IPatientService patientService;
	
	@GetMapping("/getpatients")
	public List<Patient> getPatient() {
		return  patientService.getAllPatient();
	}
	
	@GetMapping("/getpatient/{id}")
	public Optional<Patient> getPatient(@PathVariable int id) {
		return patientService.getPatientById(id);
	}
	
	@PostMapping("/addpatient")
	public Patient addPatient(@RequestBody Patient patient){
		return patientService.addNewPatient(patient);
	}
	
	
	@PutMapping("/updatepname/{id}")
	public Patient updatePatient(@RequestBody Patient pat,@PathVariable int id)
	{
		return patientService.updatePatName(pat,id);
	}
	
	@DeleteMapping("/deletep/{id}")
	public void deletePatient(@PathVariable int id) {
		 patientService.deletePatientById(id);
	}

	
}
