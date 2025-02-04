package com.tut.feign;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.tut.dto.DoctorDTO;

@Component
public class DoctorFeignClientFallBack implements IDoctorFeignClient{

	@Override
	public Optional<DoctorDTO> getDoctorById(int id) {
		System.out.println("Falling Back for Doctor");
		return Optional.ofNullable(new DoctorDTO());
	}
}
