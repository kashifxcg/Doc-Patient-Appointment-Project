package com.tut.dto;

import java.time.LocalDate;

import com.tut.model.Appointment;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	
	private int did;
	
	private int pid;

	public String time;
	
	public LocalDate date;


	public static AppointmentDTO fromEntity(Appointment appointment) {
        return new AppointmentDTO(
            appointment.getAid(),
            appointment.getDid(),
            appointment.getPid(),
            appointment.getTime(),
            appointment.getDate()
        );
    }

 
    public Appointment toEntity() {
        return new Appointment(
           this.aid,
           this.did,
           this.pid,
           this.time,
           this.date
        );
    }
}
