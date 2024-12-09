package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Doctor;

@Repository  			//Doctor from entity is Integer for id in doctor class
public interface IDocRepo extends JpaRepository<Doctor, Integer>{
//	JpaRepository <Doctor,Integer>  <EntityClassName,primary key>
		
}
