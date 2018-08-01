package com.qf.hrm.controll;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qf.hrm.pojo.Dept;
import com.qf.hrm.pojo.Employee;
import com.qf.hrm.pojo.Job;
import com.qf.hrm.pojo.User;
import com.qf.hrm.service.impl.DeptService;
import com.qf.hrm.service.impl.EmployeeService;
import com.qf.hrm.service.impl.JobService;

@Controller
public class EmployeeControll {
	
	@Resource
	private EmployeeService employeeService;
	@Resource
	private JobService jobService;
	@Resource
	private DeptService deptService;
	/**
	 * 员工查询
	 * @param employee
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("employee/selectEmployee.action")
	public ModelAndView selectEmployee(String  job_id,String name,String cardId,Integer sex,String phone,String dept_id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<Job> jobs = jobService.listAll();
		List<Dept> depts = deptService.listAll();
		List<Employee> list = employeeService.queryEmployee(dept_id, 
				job_id,name, 
				cardId,phone, sex);
		modelAndView.addObject("employees", list);	
		modelAndView.addObject("depts", depts);
		modelAndView.addObject("jobs", jobs);
		modelAndView.setViewName("employee/employee");
		return modelAndView;
	}
	
	/**
	 * 跳转至添加员工
	 * @param employee
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("employee/addEmployee.action")
	public ModelAndView toAddEmployee(Employee employee) throws Exception{
		System.out.println("跳转至添加员工");
		ModelAndView modelAndView = new ModelAndView();
		List<Job> jobs = jobService.listAll();
		List<Dept> depts = deptService.listAll();
		modelAndView.addObject("depts", depts);
		modelAndView.addObject("jobs", jobs);
		modelAndView.setViewName("employee/showAddEmployee");
		return modelAndView;
	}
	
	/**
	 * 添加员工
	 * @param employee
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("employee/addEmployee1.action")
	public ModelAndView addEmployee(Employee employee,Integer job_id,Integer dept_id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Job job = jobService.queryJobById(job_id);
		Dept dept = deptService.queryDeptById(dept_id);
		employee.setDept(dept);
		employee.setJob(job);
		employeeService.addEmployee(employee);
		List<Employee> list = employeeService.listAll();
		List<Job> jobs = jobService.listAll();
		List<Dept> depts = deptService.listAll();
		modelAndView.addObject("depts", depts);
		modelAndView.addObject("jobs", jobs);
		modelAndView.addObject("employees", list);
		modelAndView.setViewName("employee/employee");
		return modelAndView;
	}
	
	
	/**
	 * 跳转至修改员工信息
	 * @param employee
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("employee/updateEmployee.action")
	public ModelAndView toUpdateEmployee(Employee employee,Integer eId) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Employee employee2 = employeeService.queryById(eId);
		List<Job> jobs = jobService.listAll();
		List<Dept> depts = deptService.listAll();
		modelAndView.addObject("depts", depts);
		modelAndView.addObject("jobs", jobs);
		modelAndView.addObject("employee", employee2);
		modelAndView.setViewName("employee/showUpdateEmployee");
		return modelAndView;
	}
	
	/**
	 * 展示员工个人信息
	 * @param employee
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("employee/showOwn.action")
	public ModelAndView showOwn(HttpServletRequest reqeust) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = reqeust.getSession();
		User user =(User) session.getAttribute("user");
		Employee employee2 = employeeService.queryByName(user.getUserName());
		List<Job> jobs = jobService.listAll();
		List<Dept> depts = deptService.listAll();
		modelAndView.addObject("depts", depts);
		modelAndView.addObject("jobs", jobs);
		modelAndView.addObject("employee", employee2);
		modelAndView.setViewName("employee/showUpdateEmployee");
		return modelAndView;
	}
	
	
	/**
	 * 修改员工信息
	 * @param employee
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("employee/updateEmployee1.action")
	public ModelAndView updateEmployee(Employee employee,Integer job_id,Integer dept_id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Job job = jobService.queryJobById(job_id);
		Dept dept = deptService.queryDeptById(dept_id);
		employee.setDept(dept);
		employee.setJob(job);
		employeeService.updateEmployee(employee);
		List<Employee> list = employeeService.listAll();
		List<Job> jobs = jobService.listAll();
		List<Dept> depts = deptService.listAll();
		modelAndView.addObject("depts", depts);
		modelAndView.addObject("jobs", jobs);
		modelAndView.addObject("employees", list);
		modelAndView.setViewName("employee/employee");
		return modelAndView;
	}
	
	/**
	 * 删除员工信息
	 * @param employee
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("employee/removeEmployee.action")
	public ModelAndView deleteEmployee(int[] ids) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<Employee> list = null;
		for(int id:ids){
			employeeService.deleteEmployee(id);
		}
		list = employeeService.listAll();
		List<Job> jobs = jobService.listAll();
		List<Dept> depts = deptService.listAll();
		modelAndView.addObject("depts", depts);
		modelAndView.addObject("jobs", jobs);
		modelAndView.addObject("employees", list);
		modelAndView.setViewName("employee/employee");
		return modelAndView;
	}
}
