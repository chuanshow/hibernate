package com.qf.hrm.dao;

import java.util.List;

import com.qf.hrm.pojo.Dept;

public interface IDeptDao {
	
	/**
	 * 添加部门
	 * @throws Exception
	 */
	public void addDept(Dept dept) throws Exception;
	
	/**
	 * 删除部门
	 * @throws Exception
	 */
	public void deleteDept(Dept dept) throws Exception;
	
	/**
	 * 修改部门
	 * @throws Exception
	 */
	public void updateDept(Dept dept) throws Exception;
	
	/**
	 * 查找部门
	 * @throws Exception
	 */
	public List<Dept> queryDept(String name) throws Exception;
	
	/**
	 * 通过id 查找部门
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Dept queryById(int id)throws Exception;
	
	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	public List<Dept> listAll()throws Exception;	
}
