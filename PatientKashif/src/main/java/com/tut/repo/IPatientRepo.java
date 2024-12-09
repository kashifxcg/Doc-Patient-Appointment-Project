package com.tut.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tut.entity.Patient;

@Repository
public interface IPatientRepo extends JpaRepository<Patient, Integer>{

}
