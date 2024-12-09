package com.tut.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tut.model.Appointment;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, Integer>{

}
