package com.qf.hrm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qf.hrm.dao.IDeptDao;
import com.qf.hrm.pojo.Dept;

@Repository
public class DeptDao implements IDeptDao {
	
	@Autowired
	private SessionFactory sessionFactory = null;
	
	@Override
	public void addDept(Dept dept) throws Exception {
		sessionFactory.openSession().save(dept);
	}

	@Override
	public void deleteDept(Dept dept) throws Exception {
		sessionFactory.getCurrentSession().delete(dept);
	}

	@Override
	public void updateDept(Dept dept) throws Exception {
		sessionFactory.getCurrentSession().update(dept);
	}

	@Override
	public List<Dept> queryDept(String name) throws Exception {
		String sql = "select d from Dept d where 1=1";
		if(name!=null && !"".equals(name)){
			sql=sql+" and dName='"+name+"'";
		}
		Query query = sessionFactory.openSession().createQuery(sql);
		List<Dept> list = query.list();
		if(list.size()<=0){
			return null;
		}else{
			return list;
		}
	}

	@Override
	public Dept queryById(int id) throws Exception {
		System.out.println("id------"+id);
		return sessionFactory.openSession().get(Dept.class,id);
	}

	@Override
	public List<Dept> listAll() throws Exception {
		String sql = "select n from Dept n ";
		Query query = sessionFactory.openSession().createQuery(sql);
		List<Dept> list = query.list();
		if(list.size()<=0){
			return null;
		}else{
			return list;
		}
	}
}
