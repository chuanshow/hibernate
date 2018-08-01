package com.qf.hrm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.hrm.dao.IJobDao;
import com.qf.hrm.pojo.Job;
import com.qf.hrm.service.IJobService;
@Service
@Transactional
public class JobService implements IJobService{
	
	@Autowired
	private IJobDao jobDao = null;
	
	@Override
	public void addJob(Job job) throws Exception {
		if(jobDao.queryJob(job.getjName()).size()>0){
			System.out.println("1111111111111已存在");
		}else{
			jobDao.addJob(job);
			System.out.println("添加job成功");
		}
	}

	@Override
	public void deleteJob(int id) throws Exception {
		Job job2 = jobDao.queryJobById(id);
		if(job2 == null){
			System.out.println(id+"de用户不存在  无法删除该用户·······");
		}else{
			jobDao.deleteJob(job2);
		}
	}

	@Override
	public void updateJob(Job job) throws Exception {
		Job job2 = jobDao.queryJobById(job.getjId());
		if(job2 == null){
			System.out.println("不存在  无法修改job·······");
		}else{
			jobDao.updateJob(job);
		}
	}

	@Override
	public List<Job> queryJob(String name) throws Exception {
		List<Job> list = jobDao.queryJob(name);
		if(list!=null){
			return list;
		}
		return null;
	}

	@Override
	public List<Job> listAll() throws Exception {
		List<Job> list = jobDao.listAll();
		if(list!=null){
			return list;
		}
		return null;
	}

	@Override
	public Job queryJobById(Integer id) throws Exception {
		Job job = jobDao.queryJobById(id);
		if(job!=null){
			return job;
		}
		return null;
	}
}
