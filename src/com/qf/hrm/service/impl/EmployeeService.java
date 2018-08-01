package com.qf.hrm.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.hrm.dao.IEmployeeDao;
import com.qf.hrm.pojo.Dept;
import com.qf.hrm.pojo.Employee;
import com.qf.hrm.pojo.Job;
import com.qf.hrm.service.IEmployeeService;

@Service
@Transactional
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private IEmployeeDao employeeDao;
	
	@Override
	public void addEmployee(Employee employee) throws Exception {
		Employee employee2 = employeeDao.qyeryByCardId(employee.getCardId());
		if(employee2!=null){
			System.out.println("该员工已存在");
		}else{
			System.out.println("员工添加");
			employee.seteDate(new Date());
			employeeDao.addEmployee(employee);
		}
	}

	@Override
	public void deleteEmployee(int id) throws Exception {
		Employee employee = employeeDao.queryById(id);
		if(employee==null){
			System.out.println("该员工不存在  不能删除");
		}else{
			employeeDao.deleteEmployee(employee);
		}
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		Employee employee2 = employeeDao.queryById(employee.geteId());
		if(employee2==null){
			System.out.println("该员工不存在   不能修改");
		}else{
			employee.seteDate(employee2.geteDate());
			employeeDao.updateEmployee(employee);
		}
	}

	@Override
	public List<Employee> queryEmployee(String dept_id, String job_id, String eName, 
		String cardId, String phone, Integer sex)throws Exception {
		List<Employee> list = employeeDao.queryEmployee(dept_id, job_id, eName, cardId, phone, sex);
		if(list.size()<=0){
			return null;
		}else{
			return list;
		}
	}

	@Override
	public List<Employee> listAll() throws Exception {
		List<Employee> list = employeeDao.listAll();
		if(list!=null){
			return list;
		}
		return null;
	}

	@Override
	public Employee queryById(Integer id) throws Exception {
		Employee employee = employeeDao.queryById(id);
		if(employee!=null){
			return employee;
		}
		return null;
	}

	@Override
	public Employee queryByName(String uName) throws Exception {
		return employeeDao.queryByName(uName);
	}

}
