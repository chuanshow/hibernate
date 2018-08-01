package com.qf.hrm.controll;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.hrm.pojo.Dept;
import com.qf.hrm.service.IDeptService;
import com.qf.hrm.service.impl.DeptService;

@Controller
public class DeptControll {
	@Resource
	private DeptService deptService;
	
	/**
	 * 查询部门
	 * @param dept
	 * @return
	 */
	@RequestMapping("dept/selectDept.action")
	public ModelAndView showDept(HttpServletRequest request ,Dept dept){
		System.out.println("部门查询··········");
		List<Dept> list = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			list = deptService.queryDept(dept.getdName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("depts", list);
		modelAndView.setViewName("dept/dept");
		return modelAndView;
	}
	
	/**
	 * 跳转至添加部门
	 * @param dept
	 * @return
	 */
	@RequestMapping("dept/addDept.action")
	public String toAddDept(Dept dept){
		return "dept/showAddDept";
	}
	
	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	@RequestMapping("dept/addDept1.action")
	public ModelAndView addDept(Dept dept){
		System.out.println("获取到的部门："+dept);
		List<Dept> lDepts = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			deptService.addDept(dept);
			lDepts = deptService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("depts", lDepts);
		modelAndView.setViewName("dept/dept");
		return modelAndView;
	}
	
	/**
	 * 删除部门
	 * @param dept
	 * @return
	 */
	@RequestMapping("dept/removeDept.action")
	public ModelAndView deleteDept(int[] ids){
		System.out.println("删除部门");
		List<Dept> lDepts = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			for(int id:ids){
				deptService.deleteDept(id);
			}
			lDepts = deptService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("depts", lDepts);
		modelAndView.setViewName("dept/dept");
		return modelAndView;
	}
	/**
	 * 跳转至修改部门
	 * @param dept
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("dept/updateDept.action")
	public ModelAndView toUpdateDept(Integer dId) throws Exception{
		System.out.println("跳转至修改部门"+dId);
		ModelAndView modelAndView = new ModelAndView();
		Dept dept = deptService.queryDeptById(dId);
		modelAndView.addObject("dept", dept);
		modelAndView.setViewName("dept/showUpdateDept");
		return modelAndView;
	}
	/**
	 * 修改部门
	 * @param dept
	 * @return
	 */
	@RequestMapping("dept/updateDept1.action")
	public ModelAndView updateDept(Dept dept){
		System.out.println("修改部门");
		List<Dept> list = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			deptService.updateDept(dept);
			list = deptService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("depts", list);
		modelAndView.setViewName("dept/dept");
		return modelAndView;
	}
}
