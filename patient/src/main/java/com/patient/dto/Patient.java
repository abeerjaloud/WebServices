package com.patient.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="patient")
public class Patient{
	
	@Id
	@Column(name="patientId", updatable=false, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int patientId; 

	@Column(name="firstName" ,nullable=false )
	private String firstName;
	
	@Column(name="secondName" ,nullable=false )
	private String secondName;
	
	@Column(name="lastName" ,nullable=false )
	private String lastName;
	
	@Column(name="age" ,nullable=false )
	private int age;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Column(name="DOB" ,nullable=false )
	private Date dateOfBirth;
	
	@Column(name="heartRate" ,nullable=false )
	private int heartRate;
	
	@Column(name="temperature" ,nullable=false )
	private int temperature;
	
	@Column(name="bloodPressure" ,nullable=false )
	private String bloodPressure;
	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	
}
