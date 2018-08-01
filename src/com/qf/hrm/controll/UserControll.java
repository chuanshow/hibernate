package com.qf.hrm.controll;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.hrm.pojo.Employee;
import com.qf.hrm.pojo.User;
import com.qf.hrm.service.IEmployeeService;
import com.qf.hrm.service.IUserService;

@Controller
public class UserControll {
	
	@Resource
	private IUserService userService;
	@Resource
	private IEmployeeService employeeService;
	/**
	 * 用户查询
	 * @param user
	 * @return
	 */
	@RequestMapping("user/selectUser.action")
	public ModelAndView queryUser(HttpServletRequest request,User user){
		ModelAndView modelAndView = new ModelAndView();
		List<User> userList = null;
		try {
			userList = userService.queryUserByTwo(user.getUserName(), user.getuStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(userList);
		modelAndView.setViewName("user/user");
		modelAndView.addObject("users", userList);
		return modelAndView;
	}
	
	
	/**
	 * 跳转至添加
	 * @param user
	 * @return
	 */
	@RequestMapping("user/addUser.action")
	public String addUserAction(User user){
		System.out.println("跳转至添加User··········");
		return "user/showAddUser";
	}	
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping("user/addUser1.action")
	public String addUser(HttpServletRequest request,User user){
		List<User> list = null;
		try {
			    list = userService.listAll();
				String uName = user.getLoginName();
				User userCheck =userService.queryUser(uName);
				if(userCheck==null){
				user.setCreatedate(new Date());
				user.setFlag("0");
				String password =user.getuPassword();
				String uPassWord=DigestUtils.md5Hex(password);
				user.setuPassword(uPassWord);
				userService.register(user);
				Employee e= new Employee();
				e.seteName(user.getUserName());
				e.seteDate(new Date());
				employeeService.addEmployee(e);
				request.setAttribute("reasult", "true");
			}else{
				request.setAttribute("reasult", "false");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("users",list);
		return "user/showAddUser";
	}	
	/**
	 * 跳转至修改页面
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("user/updateUser.action")
	public ModelAndView updateUserAction(User user,Integer id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		User user2 = userService.queryUserById(id);
		modelAndView.addObject("user", user2);
		modelAndView.setViewName("user/showUpdateUser");
		return modelAndView;
	}	
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@RequestMapping("user/updateUser1.action")
	public String updateUser(HttpServletRequest request,User user){
		List<User> list = null;
		try {
			String password = user.getuPassword();
			String uPassWord=DigestUtils.md5Hex(password);
			user.setuPassword(uPassWord);
			userService.updateUser(user);
			list = userService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		request.setAttribute("users",list);
		return "user/user";
	}	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("user/removeUser.action")
	public ModelAndView deleteUser(int[] ids) throws Exception{
		List<User> list = null;
		ModelAndView modelAndView = new ModelAndView();
		for(int id:ids){
			userService.deleteUser(id);
		}
		list = userService.listAll();
		modelAndView.setViewName("user/user");
		modelAndView.addObject("users", list);
		return modelAndView;
	}	
}
