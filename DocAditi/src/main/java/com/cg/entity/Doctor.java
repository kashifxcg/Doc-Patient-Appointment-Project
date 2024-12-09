package com.cg.entity;

//import org.antlr.v4.runtime.misc.NotNull;

//import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
//Think of it as Model AKA Entity


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "docTable")
public class Doctor {
	
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	@NotNull( message= "name cannot be null" )
	private String name;
	
	@NotNull(message="qualification cannot be null")
	private String qualification;
	
}
