package com.patient.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@Column(name = "Patientid", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer patientId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "second_name", nullable = false)
	private String secondName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "dob", nullable = false)
	private Date dateOfBirth;

	@Column(name = "heart_rate", nullable = false)
	private int heartRate;

	@Column(name = "temperature", nullable = false)
	private int temperature;

	@Column(name = "blood_pressure", nullable = false)
	private String bloodPressure;

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
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

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", secondName=" + secondName
				+ ", lastName=" + lastName + ", age=" + age + ", dateOfBirth=" + dateOfBirth + ", heartRate="
				+ heartRate + ", temperature=" + temperature + ", bloodPressure=" + bloodPressure + "]";
	}

}
