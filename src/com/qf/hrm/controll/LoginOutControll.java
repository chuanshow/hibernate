package com.qf.hrm.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.hrm.pojo.User;

@Controller
public class LoginOutControll {

	@RequestMapping("/logout.action")
	public ModelAndView login(User user){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginForm");
		return modelAndView;
	}
}
