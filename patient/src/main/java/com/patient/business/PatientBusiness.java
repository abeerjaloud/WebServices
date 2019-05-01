package com.patient.business;
import com.patient.entity.Patient;
import java.util.List;

public interface PatientBusiness {
	public Patient getPatient(int id);
	public List<Patient> getAllPatients();
}
