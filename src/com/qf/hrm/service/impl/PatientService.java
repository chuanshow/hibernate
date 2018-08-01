package com.qf.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qf.hrm.dao.IPatientDao;
import com.qf.hrm.pojo.Patient;
import com.qf.hrm.service.IPatientService;
@Repository
public class PatientService implements IPatientService{
  @Autowired IPatientDao IpatientDao=null;
	@Override
	public void delete(Patient patient) throws Exception {
		IpatientDao.delete(patient);
		
	}

	@Override
	public void update(Patient patient) throws Exception {
		IpatientDao.update(patient);
	}

	@Override
	public void add(Patient patient) throws Exception {
		IpatientDao.add(patient);
	}

	@Override
	public List<Patient> findAllPatient() throws Exception {
		return IpatientDao.findAllPatient();
	}

	@Override
	public List<Patient> findPatient(String name) throws Exception {
		return IpatientDao.findPatient(name);
	}

}
