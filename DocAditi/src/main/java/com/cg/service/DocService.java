package com.cg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.DoctorDTO;
import com.cg.entity.Doctor;
import com.cg.repo.IDocRepo;


@Service
public class DocService implements IDocService{
	
	@Autowired
	IDocRepo docRepo;
	
	@Override
	public List<DoctorDTO> getdocs() {
		
		List<Doctor> ls = docRepo.findAll();
		return ls.stream().map(DoctorDTO::fromEntity).collect(Collectors.toList());
		
//		return docRepo.findAll();
	}

	@Override
	public DoctorDTO createDocInDB(Doctor doc) {
		docRepo.save(doc);
		return DoctorDTO.fromEntity(doc);
		
//		return docRepo.save(doc);
	}

	@Override
	public Optional<DoctorDTO> getById(int id) {
		Optional<Doctor> docTmp = docRepo.findById(id);
		Optional<DoctorDTO> docDto = Optional.ofNullable(DoctorDTO.fromEntity(docTmp.get()));
		return docDto;
	}

	
	@Override
	public Doctor updateDoc(int id, Doctor doc) {
		Optional<Doctor> d =  docRepo.findById(id);
		if(!d.isEmpty())
		{
			Doctor dd = d.get();
			dd.setName(doc.getName());
			dd.setQualification(doc.getQualification());
			docRepo.save(dd);
		}
		return d.get();
	}

	@Override
	public void deleteDoc(int id) 
	{
		 docRepo.deleteById(id);
	}
	
}
