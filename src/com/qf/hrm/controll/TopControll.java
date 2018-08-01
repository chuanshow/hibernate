package com.qf.hrm.controll;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qf.hrm.pojo.User;

@Controller
public class TopControll {

//	@RequestMapping()
//	public ModelAndView selectNotice(HttpServletRequest request){
//		ModelAndView modelAndView = new ModelAndView();
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
////		modelAndView.setViewName("top");
////		modelAndView.addObject("user_session", user);
//		return modelAndView;
//	}
}
