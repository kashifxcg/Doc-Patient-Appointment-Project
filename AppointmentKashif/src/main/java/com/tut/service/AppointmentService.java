package com.tut.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tut.model.Appointment;
import com.tut.repo.IAppointmentRepo;

@Service
public class AppointmentService implements IAppointmentService{

	@Autowired
	IAppointmentRepo appoRepo;
	
	@Override
	public List<Appointment> getAllAppointment() {
		
		return appoRepo.findAll();
	}

	@Override
	public Appointment addAppointment(Appointment appo) {
		return appoRepo.save(appo);
	}

	@Override
	public Appointment updateApp(int id, Appointment entity) {
			Optional<Appointment> ap= appoRepo.findById(id);
			if(!ap.isEmpty()) {
				Appointment obj = ap.get();
				obj.setDate(entity.getDate());
				obj.setDid(entity.getDid());
				obj.setPid(entity.getPid());
				obj.setTime(entity.getTime());
				appoRepo.save(obj);
			}
		return ap.get();
	}

	@Override
	public void deleteAppointmentById(int id) {
		appoRepo.deleteById(id);
		
	}

}
