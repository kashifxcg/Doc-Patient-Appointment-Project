package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.dto.DoctorDTO;
import com.cg.entity.Doctor;

public interface IDocService {

	List<DoctorDTO> getdocs();

	DoctorDTO createDocInDB(Doctor doc);

	Optional<DoctorDTO> getById(int id);

	Doctor updateDoc(int id, Doctor doc);

	void deleteDoc(int id);

}
