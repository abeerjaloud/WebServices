package com.patient.dto;
import org.springframework.stereotype.Component;

import com.patient.entity.Patient;

@Component
public class GetPatientResponse {

	private Patient patient;
	
	private BaseResponse baseResponse;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public BaseResponse getBaseResponse() {
		return baseResponse;
	}

	public void setBaseResponse(BaseResponse baseResponse) {
		this.baseResponse = baseResponse;
	}
	
	
}
