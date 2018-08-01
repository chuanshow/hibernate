package com.qf.hrm.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.hrm.pojo.User;

@Controller
public class MainControll {
	
	@RequestMapping("/main.action")
	public String main(){
		return "loginForm";
	}
	
	@RequestMapping("/left.action")
	public String left(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("user="+user);
		if(user!=null){
			if("1".equals(user.getFlag())){
				return "leftAdmin";
			}else{
				return "left";
			}
		}else{
			return "left";
		}
		
	}
	
	@RequestMapping("/right.action")
	public ModelAndView right(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		modelAndView.setViewName("right");
		modelAndView.addObject("user_session", user);
		return modelAndView;
	}
	
	
	@RequestMapping("/taglib.action")
	public String taglib(){
		return "taglib";
	}
	
	@RequestMapping("/top.action")
	public ModelAndView top(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		modelAndView.setViewName("top");
		modelAndView.addObject("user_session", user);
		return modelAndView;
	}
	
	
}
