package com.patient.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.patient.business.PatientBusiness;
import com.patient.dto.BaseResponse;
import com.patient.dto.GetPatientResponse;
import com.patient.entity.Patient;

@RestController
@RequestMapping("/patient")
public class PatientService {
	@Autowired
	PatientBusiness patientBusiness;

	@RequestMapping("/hello")
	public String hello() {
		return "Abeer & Sara say Hi!";
	}

	@RequestMapping("/getPatient/{id}")
	public GetPatientResponse getPatientById(@PathVariable("id") int patientId) {
		System.out.println("Patient Id =====>   " + patientId);

		return patientBusiness.getPatient(patientId);
	}

	@RequestMapping("/listPatients")
	public GetPatientResponse getPatients() {

		return patientBusiness.getAllPatients();
	}
}
