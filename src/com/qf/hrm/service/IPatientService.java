package com.qf.hrm.service;

import java.util.List;

import com.qf.hrm.pojo.Patient;

public interface IPatientService {
void delete(Patient patient)throws Exception;
	
	void update(Patient patient)throws Exception;
	
	void add(Patient patient)throws Exception;
	
	List<Patient> findAllPatient()throws Exception;
	
	List<Patient> findPatient(String name)throws Exception;
}
