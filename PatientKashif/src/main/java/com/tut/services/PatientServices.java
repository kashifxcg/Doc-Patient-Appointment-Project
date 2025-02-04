package com.tut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tut.entity.Patient;
import com.tut.repo.IPatientRepo;

@Service
public class PatientServices implements IPatientService{
	
	@Autowired
	IPatientRepo patientRepo;

	@Override
	public List<Patient> getAllPatient() {
		return patientRepo.findAll();
		
		
	}

	@Override
	public Optional<Patient> getPatientById(int id) {
		
		return patientRepo.findById(id);
	}

	@Override
	public Patient addNewPatient(Patient patient) {
		
		return patientRepo.save(patient);
	}

	@Override
	public Patient updatePatName(Patient pat, int id) {
		Optional<Patient> p= patientRepo.findById(id);
		if(!p.isEmpty()) {
			
			Patient pobject= p.get();
			pobject.setPname(pat.getPname());
			pobject.setDisease(pat.getDisease());
			patientRepo.save(pobject);
		}
		return p.get();
	}

	
	@Override
	public void deletePatientById(int id) {
		Optional<Patient> p = patientRepo.findById(id);
		if(p.isEmpty()) System.out.println("Patient not exist!!!!!!!!!!!!!!!");
		else patientRepo.deleteById(id);
	} 

}
