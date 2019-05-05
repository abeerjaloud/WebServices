package com.patient.business;

import com.patient.dto.BaseResponse;
import com.patient.dto.GetPatientResponse;
import com.patient.entity.Patient;
import java.util.List;

public interface PatientBusiness {
	public GetPatientResponse getPatient(int id);

	public GetPatientResponse getAllPatients();
	
	public BaseResponse addPatient(Patient patient);
	
	public GetPatientResponse updatePatient(Patient patient);
	
	public BaseResponse hardDeletePatient(int patientId);
	
	public BaseResponse softDeletePatient(int patientId);
}
