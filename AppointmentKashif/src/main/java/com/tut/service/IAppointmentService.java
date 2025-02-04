package com.tut.service;

import java.util.List;

import com.tut.model.Appointment;

public interface IAppointmentService {

	List<Appointment> getAllAppointment();

	Appointment addAppointment(Appointment appo);

	Appointment updateApp(int id, Appointment entity);

	void deleteAppointmentById(int id);

}
