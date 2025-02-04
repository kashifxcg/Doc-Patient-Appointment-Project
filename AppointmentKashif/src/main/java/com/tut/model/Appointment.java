package com.tut.model;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="appointment_table")
@AllArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="app_id")
	private int aid;
	
	@Column(name="doctor_id") 
	private int did;
	
	@Column(name="patient_id")
	private int pid;
	
	@Column(name="column_name")
	public String time;
	
	@Column(name="date")
	public LocalDate date;
	
}
