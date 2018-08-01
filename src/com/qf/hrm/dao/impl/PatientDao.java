package com.qf.hrm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qf.hrm.dao.IPatientDao;
import com.qf.hrm.pojo.Patient;

@Repository
@Transactional
public class PatientDao implements IPatientDao {
	
	@Autowired 
	private SessionFactory sessionFactory=null;
	
	@Override
	public void delete(Patient patient) throws Exception {
		sessionFactory.getCurrentSession().delete(patient);
	}

	@Override
	public void update(Patient patient) throws Exception {
		sessionFactory.getCurrentSession().update(patient);
		
	}

	@Override
	public void add(Patient patient) throws Exception {
		sessionFactory.getCurrentSession().save(patient);
	}

	@Override
	public List<Patient> findAllPatient() throws Exception {
		String sql =" select * from t_patient p  ";
		Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);  
		return query.list();
	}

	@Override
	public List<Patient> findPatient(String name) throws Exception {
		String sql ="select * from t_patient p where p.customer_name='"+name+"' ";
		Query query=sessionFactory.getCurrentSession().createSQLQuery(sql);  
		return query.list();
	}

}
