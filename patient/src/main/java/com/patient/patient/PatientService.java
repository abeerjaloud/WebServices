package com.patient.patient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.dto.BaseResponse;
import com.patient.dto.GetPatientResponse;
import com.patient.dto.Patient;

@RestController
@RequestMapping("/patient")
public class PatientService {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Abeer & Sara say Hi!";
	}
	
	@RequestMapping("/getPatient/{id}")
	public GetPatientResponse getPatientById(@PathVariable("id") int patientId) {
		System.out.println("Patient Id =====>   " + patientId);
		GetPatientResponse response = new GetPatientResponse();
		Patient patient = new Patient();
		BaseResponse base = new BaseResponse();
		
		// Patient
		patient.setName("Raed");
		patient.setAge(27);
		
		// Base
		base.setMessage("SUCCESS!!!");
		base.setCode(1);
		base.setResultCode("SUCCESS");
		
		// Response
		response.setPatient(patient);
		response.setBaseResponse(base);
		
		return response;
	}
}
