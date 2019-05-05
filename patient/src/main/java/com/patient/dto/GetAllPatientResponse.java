package com.patient.dto;

import java.util.List;
import com.patient.entity.Patient;

public class GetAllPatientResponse {

	private List<Patient> patients;
	private BaseResponse baseResponse;

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public BaseResponse getBaseResponse() {
		return baseResponse;
	}

	public void setBaseResponse(BaseResponse baseResponse) {
		this.baseResponse = baseResponse;
	}

}
