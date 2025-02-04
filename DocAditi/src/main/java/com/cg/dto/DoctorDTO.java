package com.cg.dto;

import com.cg.entity.Doctor;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
	
	private int id;
	private String name;
	private String qualification;
	
	public static DoctorDTO fromEntity(Doctor doc ) {
			return new DoctorDTO(doc.getId(), doc.getName(), doc.getQualification());
	}
	
	public Doctor toEntity() {
		return new Doctor(this.id,this.name,this.qualification);
	}
	
}
