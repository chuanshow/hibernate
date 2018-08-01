package com.qf.hrm.controll;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.hrm.pojo.Patient;
import com.qf.hrm.service.IPatientService;

@Controller
public class PatientController {
	@Resource
	private IPatientService IPatientService=null;
	
	@RequestMapping("patient/addPatient.action")
	public ModelAndView addPatient(Patient patient) throws Exception{
		System.out.println(123);
		ModelAndView modelAndView = new ModelAndView();
		IPatientService.add(patient);
		modelAndView.setViewName("patient/patient");
		return modelAndView;
	}
	@RequestMapping("patient/findall.action")
	public ModelAndView findAll(Patient patient) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List patients =IPatientService.findAllPatient();
		modelAndView.addObject("patients", patients);
		modelAndView.setViewName("patient/patient");
		return modelAndView;
	}
	@RequestMapping("patient/add1.action")
	public ModelAndView toAdd(Patient patient) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("patient/addPatient");
		return modelAndView;
	}
}
