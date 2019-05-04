package com.patient.business;

import com.patient.dto.BaseResponse;
import com.patient.dto.GetPatientResponse;
import com.patient.entity.Patient;
import java.util.List;

public interface PatientBusiness {
	public GetPatientResponse getPatient(int id);

	public GetPatientResponse getAllPatients();
}
