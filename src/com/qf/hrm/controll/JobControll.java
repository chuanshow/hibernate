package com.qf.hrm.controll;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.hrm.pojo.Job;
import com.qf.hrm.service.IJobService;


@Controller
public class JobControll {
	
	@Resource
	private IJobService jobService;
	
	/**
	 * 职位查询
	 * @param job
	 * @return
	 */
	@RequestMapping("job/selectJob.action")
	public ModelAndView selectJob(HttpServletRequest request , Job job){
		List<Job> jobsList = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			jobsList = jobService.queryJob(job.getjName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("jobs", jobsList);
		modelAndView.setViewName("job/job");
		return modelAndView;
	}
	
	/**
	 * 跳转至职位添加
	 * @param job
	 * @return
	 */
	@RequestMapping("job/addJob.action")
	public String addToJob(Job job){
		return "job/showAddJob";
	}
	
	
	/**
	 * 添加职位
	 * @param job
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("job/addJob1.action")
	public ModelAndView addJob(Job job) throws Exception{
		List<Job> list = null;
		System.out.println("从页面获取到的job："+job);
		ModelAndView modelAndView = new ModelAndView();
		jobService.addJob(job);
		list = jobService.listAll();
		System.out.println(list);
		modelAndView.addObject("jobs", list);
		modelAndView.setViewName("job/job");
		return modelAndView;
	}
	
	/**
	 * 跳转至职位修改
	 * @param job
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("job/updateJob.action")
	public ModelAndView updateToJob(Job job,Integer jId) throws Exception{
		Job job2 = jobService.queryJobById(jId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("job", job2);
		modelAndView.setViewName("job/showUpdateJob");
		return modelAndView;
	}
	
	
	/**
	 * 修改职位
	 * @param job
	 * @return
	 */
	@RequestMapping("job/updateJob1.action")
	public ModelAndView updateJob(Job job){
		List<Job> list = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			jobService.updateJob(job);
			list = jobService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("jobs", list);
		modelAndView.setViewName("job/job");
		return modelAndView;
	}
	
	/**
	 * 删除职位
	 * @param job
	 * @return
	 */
	@RequestMapping("job/removeJob.action")
	public ModelAndView deleteJob(Job job,int[] ids){
		List<Job> list = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			for(int id:ids){
				jobService.deleteJob(id);
			}
			list = jobService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("jobs", list);
		modelAndView.setViewName("job/job");
		return modelAndView;
	}
	
}
