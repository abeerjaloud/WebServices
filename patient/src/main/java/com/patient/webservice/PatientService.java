package com.patient.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public BaseResponse addPatient(@RequestBody Patient patient) {
		BaseResponse response = new BaseResponse();
		// System.out.println("Successfully added patient: " + patient);
		String error = validatePatient(patient);

		if (error != null) {
			response.setMessage(error);
			response.setCode(2);
			response.setResultCode("FAIL");
		}

		else {
			patientBusiness.addPatient(patient);
			response.setMessage("Successfully added patient");
			response.setCode(1);
			response.setResultCode("SUCCESS");
		}
		return response;

	}

	private String validatePatient(Patient patient) {
		String message = null;

		 if (patient.getFirstName().isEmpty()) {
			message = "FirstName must be required";
		}

		else if (patient.getSecondName().isEmpty()) {
			message = "SecondName must be required";
		}

		else if (patient.getLastName().isEmpty()) {
			message = "LastName must be required";
		}

		else if (patient.getBloodPressure().isEmpty()) {
			message = "BloodPressure must be required";
		}

		else if (patient.getAge() < 0 || patient.getAge() > 150) {
			message = "Age must be between 1-150";
		}
	
		else if (patient.getHeartRate() < 0 || patient.getHeartRate() > 300) {
			message = "Heart rate must be between 0-300";
		}

		// if (patient.getFirstName() == null || patient.getSecondName() == null ||
		// patient.getLastName() == null
		// || patient.getBloodPressure() == null || patient.getDateOfBirth() == null) {
		// message = " Required ";
		// }

		// else if(patient.getAge() == null) {

		// message ="";
		// }
		// else if (!patient.getFirstName().matches("/^[a-zA-Z]*$/") ||
		// !patient.getSecondName().matches("/^[a-zA-Z]*$/")
		// || !patient.getLastName().matches("/^[a-zA-Z]*$/")) {
		// message = "Only letters no numbers ";
		// }
		// else if(patient.getFirstName().isEmpty()||patient.getSecondName().isEmpty()
		// ||patient.getLastName().isEmpty() ) {
		// message = "Please";
		// }
		// if (!(patient.getFirstName().matches("[A-Z][a-z]*"))) {
		//		message = "FirstName must be letters";
		//	}

		return message;
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
