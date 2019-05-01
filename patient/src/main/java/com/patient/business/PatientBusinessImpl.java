package com.patient.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.patient.dao.PatientDao;
import com.patient.entity.Patient;

@Service
@Transactional
public class PatientBusinessImpl implements PatientBusiness{
	
	@Autowired
	private PatientDao patientDao;
	
	
	public Patient getPatient(int id) {
		Patient patient = patientDao.getOne(id);
		System.out.println(patient);
		return patient;
	}
	public List<Patient> getAllPatients() {
		List<Patient> patientsList = patientDao.findAll();
		
		return patientsList;
	}
}
