package com.qf.hrm.controll;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.hrm.pojo.User;
import com.qf.hrm.service.impl.UserService;

@Controller
public class LoginControll {

	@Resource
	private UserService userService;
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping("/login.action")
	public ModelAndView login(HttpServletRequest request,User user){
		ModelAndView modelAndView = new ModelAndView();
		try {
			String password = user.getuPassword();
			String uPassWord=DigestUtils.md5Hex(password);
			user.setuPassword(uPassWord);
			System.out.println(uPassWord);
			User user2 = userService.login(request, user);
			if(user2==null){
				request.setAttribute("loginMsg", "false");
				modelAndView.setViewName("loginForm");
			}else{
				modelAndView.setViewName("main");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
}
