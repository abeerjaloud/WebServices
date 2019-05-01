package com.patient.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.patient.webservice.PatientService;

@Configuration
@ComponentScan(basePackages = {"com.patient.webservice"}, basePackageClasses = PatientService.class)
@SpringBootApplication
public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

}
