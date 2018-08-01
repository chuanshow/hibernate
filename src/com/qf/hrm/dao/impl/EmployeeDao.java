package com.qf.hrm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qf.hrm.dao.IEmployeeDao;
import com.qf.hrm.pojo.Dept;
import com.qf.hrm.pojo.Employee;
import com.qf.hrm.pojo.Job;

@Repository
public class EmployeeDao implements IEmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory = null;
	
	@Override
	public void addEmployee(Employee employee) throws Exception {
		sessionFactory.openSession().save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) throws Exception {
		sessionFactory.getCurrentSession().delete(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		sessionFactory.getCurrentSession().update(employee);
	}

	@Override
	public List<Employee> queryEmployee(String dept_id, String job_id, String eName, String cardId, String phone, Integer sex)
		throws Exception {
		String sql = "select e from Employee e where 1=1";
		if(dept_id!=null&&!"0".equals(dept_id)){
			sql = sql + " and d_id="+dept_id;
		}if(job_id!=null&&!"0".equals(job_id)){
			sql = sql + " and j_id="+job_id;
		}if(eName!=null && !"".equals(eName)){
			sql = sql + " and eName='"+eName+"'";
		}if(cardId!=null && !"".equals(cardId)){
			sql = sql + " and cardId='"+cardId+"'";
		}if(phone!=null && !"".equals(phone)){
			sql = sql + " and phone='"+phone+"'";
		}if(sex!=null && sex!=0){
			sql = sql + " and sex="+sex;
		}
		Query query = sessionFactory.openSession().createQuery(sql);
		List<Employee> lEmployees = query.list();
		if(lEmployees!=null){
			return lEmployees;
		}else {
			return null;
		}
	}

	@Override
	public List<Employee> listAll() throws Exception {
		String sql = "select n from Employee n ";
		Query query = sessionFactory.openSession().createQuery(sql);
		List<Employee> list = query.list();
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}

	@Override
	public Employee queryById(Integer id) throws Exception {
		return sessionFactory.openSession().get(Employee.class, id);
	}

	@Override
	public Employee qyeryByCardId(String cardId) throws Exception {
		Query query = sessionFactory.openSession().createQuery("select n from Employee n where cardId='"+cardId+"'");
		 List<Employee> list = query.list();
//		 return list!=null?list.get(0):null;
		 if(list.size()>0){
			 Employee employee = list.get(0);
			 return employee;
		 }else{
			 return null;
		 }
	}

	@Override
	public Employee queryByName(String uName ) throws Exception {
		String hql ="from Employee e where e.eName='"+uName+"'";
		List list =sessionFactory.getCurrentSession().createQuery(hql).list();
		if(list.size()>0){
			return (Employee) list.get(0);
		}
		return null;
	}
}
