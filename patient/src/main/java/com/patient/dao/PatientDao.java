package com.patient.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.entity.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer>{
	
		List<Patient> findByAge(Integer age);
}