package com.qf.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.hrm.dao.IDeptDao;
import com.qf.hrm.pojo.Dept;
import com.qf.hrm.service.IDeptService;
@Service
@Transactional
public class DeptService implements IDeptService{
	
	@Autowired
	private IDeptDao deptDao = null;
	/**
	 * 添加部门
	 */
	@Override
	public void addDept(Dept dept) throws Exception {
		if(deptDao.queryDept(dept.getdName())!=null){
			System.out.println("该部门已存在   不能添加·······");
			System.out.println(deptDao.queryDept(dept.getdName()));
		}else{
			deptDao.addDept(dept);
		}
	}
	/**
	 * 删除部门
	 * 
	 */
	@Override
	public void deleteDept(int id) throws Exception {
		Dept dept = deptDao.queryById(id);
		if(dept==null){
			System.out.println("部门不存在   不能删除·········");
		}else{
			deptDao.deleteDept(dept);
		}
	}

	/**
	 * 修改部门
	 * 
	 */
	@Override
	public void updateDept(Dept dept) throws Exception {
		Dept dept2 = deptDao.queryById(dept.getdId());
		if(dept2==null){
			System.out.println("部门不存在   不能修改·········");
		}else{
			deptDao.updateDept(dept);
		}
	}

	/**
	 * 查找部门
	 * 
	 */
	@Override
	public List<Dept> queryDept(String name) throws Exception {
		 List<Dept> list = deptDao.queryDept(name);
		 if(list!=null){
			 return list;
		 }
		 return null;
	}
	/**
	 * 展示所有部门集合
	 */
	@Override
	public List<Dept> listAll() throws Exception {
		List<Dept> list = deptDao.listAll();
		if(list!=null){
			 return list;
		 }
		 return null;
	}
	@Override
	public Dept queryDeptById(Integer id) throws Exception {
		Dept dept = deptDao.queryById(id);
		if(dept!=null){
			return dept;
		}
		return null;
	}
}
