package com.patient.webservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.dto.Patient;

@RestController
@RequestMapping("/patient")
public class PatientService {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Abeer & Sara say Hi!";
	}
	
	@RequestMapping("/getPatient/{id}")
	public Patient getPatientById(@PathVariable("id") int patientId) {
		System.out.println("Patient Id =====>   " + patientId);
		
		Patient patient = new Patient();
		
		//patient.setFirstName("Raed");
	//	patient.setAge(27);
		patient.getFirstName();
		
		return patient;
	}
}
