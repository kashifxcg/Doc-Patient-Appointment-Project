package com.tut.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tut.dto.DoctorDTO;

// url is for product service to communicate with appointment , fallback is for handling circuit breaker 
@FeignClient(name="testFeignClient",url="${PRODUCT_SERVICE:http://localhost:8080}", fallback = DoctorFeignClientFallBack.class)
public interface IDoctorFeignClient {
	
	// same endpoint as present in doc Controller
	@GetMapping("/getbyId/{id}")
	Optional<DoctorDTO> getDoctorById(@PathVariable int id);
	
}
