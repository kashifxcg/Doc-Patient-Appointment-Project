package com.tut.services;

import java.util.List;
import java.util.Optional;

import com.tut.entity.Patient;

public interface IPatientService {

	List<Patient> getAllPatient();

	Optional<Patient> getPatientById(int id);

	Patient addNewPatient(Patient patient);

	Patient updatePatName(Patient pat, int id);

	void deletePatientById(int id);

	

}
