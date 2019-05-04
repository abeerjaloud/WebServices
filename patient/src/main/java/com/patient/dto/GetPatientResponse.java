package com.patient.dto;

import java.util.List;

import com.patient.entity.Patient;

public class GetPatientResponse {

	private Patient patient;

	private List<Patient> patients;

	private BaseResponse baseResponse;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

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
