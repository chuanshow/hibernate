package com.qf.hrm.service;

import java.util.List;

import com.qf.hrm.pojo.Dept;
import com.qf.hrm.pojo.Employee;
import com.qf.hrm.pojo.Job;

public interface IEmployeeService {
	/**
	 * 添加员工
	 * @throws Exception
	 */
	public void addEmployee(Employee employee) throws Exception;
	
	/**
	 * 删除员工
	 * @throws Exception
	 */
	public void deleteEmployee(int id) throws Exception;
	
	/**
	 * 修改员工
	 * @throws Exception
	 */
	public void updateEmployee(Employee employee) throws Exception;
	
	/**
	 * 查找员工
	 * @throws Exception
	 */
	public List<Employee> queryEmployee(String dept_id, String  job_id, String eName, 
			String cardId, String phone, Integer sex) throws Exception;
	
	/**
	 * 查询所有员工
	 * @return
	 * @throws Exception
	 */
	public List<Employee>  listAll()throws Exception;
	
	/**
	 * 通过id查询
	 * @return
	 * @throws Exception
	 */
	public Employee queryById(Integer id)throws Exception;
	/**
	 * 展示个人信息
	 * 
	 */
	public Employee queryByName(String uName)throws Exception;
}
