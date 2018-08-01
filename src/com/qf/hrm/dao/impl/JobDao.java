package com.qf.hrm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qf.hrm.dao.IJobDao;
import com.qf.hrm.pojo.Job;
import com.qf.hrm.pojo.User;

@Repository
public class JobDao implements IJobDao{
	
	@Autowired
	private SessionFactory sessionFactory = null;

	@Override
	public void addJob(Job job) throws Exception {
		sessionFactory.openSession().save(job);
	}

	@Override
	public void deleteJob(Job job) throws Exception {
		sessionFactory.getCurrentSession().delete(job);
	}

	@Override
	public void updateJob(Job job) throws Exception {
		sessionFactory.getCurrentSession().update(job);
	}

	@Override
	public List<Job> queryJob(String name) throws Exception {
		String sql = "select j from Job j where 1=1";
		if(name!=null && !"".equals(name)){
			sql = sql+" and jName='"+name+"'";
		}
		Query query = sessionFactory.openSession().createQuery(sql);
		List<Job> list = query.list();
		return list;
	}

	@Override
	public Job queryJobById(Integer id) throws Exception {
		System.out.println("id=========="+id);
		 return sessionFactory.openSession().get(Job.class, id);
		 
	}

	@Override
	public List<Job> listAll() throws Exception {
		String sql = "select n from Job n ";
		Query query = sessionFactory.openSession().createQuery(sql);
		List<Job> list = query.list();
		if(list!=null){
			return list;
		}
		return null;
	}

}
