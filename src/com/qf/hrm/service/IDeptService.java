package com.qf.hrm.service;

import java.util.List;

import com.qf.hrm.pojo.Dept;

public interface IDeptService {
	
	/**
	 * 添加部门
	 * @throws Exception
	 */
	public void addDept(Dept dept) throws Exception;
	
	/**
	 * 删除部门
	 * @throws Exception
	 */
	public void deleteDept(int id) throws Exception;
	
	/**
	 * 修改部门
	 * @throws Exception
	 */
	public void updateDept(Dept dept) throws Exception;
	
	
	/**
	 * 通过部门名字查找部门
	 * @throws Exception
	 */
	public List<Dept> queryDept(String name) throws Exception;
	
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Dept queryDeptById(Integer id) throws Exception;
	
	/**
	 * 查询所有部门
	 * @return
	 * @throws Exception
	 */
	public List<Dept> listAll()throws Exception;
	
}
