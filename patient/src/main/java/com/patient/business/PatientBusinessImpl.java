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

	public BaseResponse addPatient(Patient patient) {

		BaseResponse response = new BaseResponse();

		patientDao.save(patient);

		return response;
	}

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
public GetPatientResponse updatePatient(Patient patient) {
		
	    GetPatientResponse response = new GetPatientResponse();
		BaseResponse baseResponse = new BaseResponse();
		
	try{
		Patient PatientDb=patientDao.getOne(patient.getPatientId());
		
		System.out.println("We have patient ==> " + patient);
		
		PatientDb.setFirstName(patient.getFirstName());
		PatientDb.setSecondName(patient.getSecondName());
		PatientDb.setLastName(patient.getLastName());
		PatientDb.setAge(patient.getAge());
		PatientDb.setDateOfBirth(patient.getDateOfBirth());
		PatientDb.setHeartRate(patient.getHeartRate());
		PatientDb.setTemperature(patient.getTemperature());
		PatientDb.setBloodPressure(patient.getBloodPressure());
		
		
		System.out.println("Before saving");		
		patientDao.save(PatientDb);
		System.out.println("after saving");
		
		
		baseResponse.setMessage("Patient ID:  "+PatientDb.getPatientId() + "Information successfully updated" );
		baseResponse.setResultCode("SUCCESS");
		baseResponse.setCode(1);
		
		
	}
	catch(Exception e){
		System.out.println("Exception!!!!!");
		baseResponse.setMessage(e.getMessage());
		baseResponse.setResultCode("FAIL");
		baseResponse.setCode(0);
		e.printStackTrace();
	}
	
		
		response.setBaseResponse(baseResponse);
		return response;
	}

public BaseResponse hardDeletePatient(int patientId) {
	BaseResponse baseResponse = new BaseResponse();
	try {
		patientDao.delete(patientDao.getOne(patientId));
		baseResponse.setMessage("Successfully deleted");
		baseResponse.setResultCode("SUCCESS");
		baseResponse.setCode(1);

	} catch (Exception e) {
		baseResponse.setMessage("Failed to delete the patient");
		baseResponse.setResultCode("FAIL");
		baseResponse.setCode(0);
	}

	return baseResponse;	
}

public BaseResponse softDeletePatient(int patientId) {
	BaseResponse baseResponse = new BaseResponse();
	try {
		Patient patient = patientDao.getOne(patientId);
		patient.setDeleted(0);
		baseResponse.setMessage("Successfully deleted");
		baseResponse.setResultCode("SUCCESS");
		baseResponse.setCode(1);

	} catch (Exception e) {
		baseResponse.setMessage("Failed to delete the patient");
		baseResponse.setResultCode("FAIL");
		baseResponse.setCode(0);
	}

	return baseResponse;
}

}
