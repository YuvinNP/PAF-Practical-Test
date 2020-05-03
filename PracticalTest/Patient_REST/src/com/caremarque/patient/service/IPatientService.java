package com.caremarque.patient.service;

import java.util.List;

import com.caremarque.patient.model.Patient;

public interface IPatientService {

	public String registerPatient(Patient patient);
	
	public List<String> getPatientIDs();

//	public String getPatientDetailById(int patientId);
	
	public String getAllPatients();
	
	//public String updatePatientDetails(Patient patient);
	public String updatePatientDetails(String patientId, String fName, String lName, String gender, String nic, String dob, String bloodGroup, String email, String phone, String pwd);


	public String deletePatient(String patientId);
//	


	//String updatePatientEmail(Patient patient);
	
}
