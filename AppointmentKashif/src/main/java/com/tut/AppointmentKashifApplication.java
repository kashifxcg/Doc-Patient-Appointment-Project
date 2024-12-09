package com.tut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//entry point of application
@SpringBootApplication
@EnableFeignClients
public class AppointmentKashifApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentKashifApplication.class, args);
	}

}
