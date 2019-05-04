package com.patient.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patient.dao.PatientDao;
import com.patient.dto.BaseResponse;
import com.patient.dto.GetPatientResponse;
import com.patient.entity.Patient;
import com.patient.util.Util;

@Service
@Transactional
public class PatientBusinessImpl implements PatientBusiness {

	@Autowired
	private PatientDao patientDao;

	public GetPatientResponse getPatient(int id) {
		GetPatientResponse response = new GetPatientResponse();
		BaseResponse baseResponse = new BaseResponse();
		try {
			Patient patient = patientDao.getOne(id);

			System.out.println(patient);

			baseResponse.setMessage("Successful retrieval of patient: " + patientDao.getOne(id).getFirstName());
			baseResponse.setResultCode("SUCCESS");
			baseResponse.setCode(1);

			response.setPatient(patient);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception!!!!!!!!");
			baseResponse.setMessage(Util.convertStackTraceToString(e));
			baseResponse.setResultCode("FAIL");
			baseResponse.setCode(0);
		}

		response.setBaseResponse(baseResponse);
		return response;
	}

	public GetPatientResponse getAllPatients() {
		GetPatientResponse response = new GetPatientResponse();
		BaseResponse baseResponse = new BaseResponse();
		try {
			List<Patient> patientsList = patientDao.findAll();

			System.out.println(patientsList);

			baseResponse.setMessage("Successful retrieval of patients");
			baseResponse.setResultCode("SUCCESS");
			baseResponse.setCode(1);
			response.setPatients(patientsList);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exception!!!!!!!!");
			baseResponse.setMessage(Util.convertStackTraceToString(e));
			baseResponse.setResultCode("FAIL");
			baseResponse.setCode(0);
		}

		response.setBaseResponse(baseResponse);

		return response;
	}
}
