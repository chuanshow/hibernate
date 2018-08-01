package com.qf.hrm.service;

import java.util.List;

import com.qf.hrm.pojo.Job;

public interface IJobService {
	/**
	 * 添加职位
	 * @throws Exception
	 */
	public void addJob(Job job)throws Exception;
	
	/**
	 * 删除职位
	 * @throws Exception
	 */
	public void deleteJob(int id)throws Exception;
	
	/**
	 * 修改职位
	 * @throws Exception
	 */
	public void updateJob(Job job)throws Exception;
	
	/**
	 * 通过名字查询职位
	 * @throws Exception
	 */
	public List<Job> queryJob(String name)throws Exception;
	
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Job queryJobById(Integer id)throws Exception;
	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	public List<Job> listAll()throws Exception;
}
