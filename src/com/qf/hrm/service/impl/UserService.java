package com.qf.hrm.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qf.hrm.dao.impl.UserDao;
import com.qf.hrm.pojo.User;
import com.qf.hrm.service.IUserService;
/**
 * 用户逻辑业务实现
 * @author Administrator
 *
 */
@Service
@Transactional
public class UserService implements IUserService{
	
	@Autowired
	private UserDao userDao = null;
	
	@Override
	public void register(User user) throws Exception {   //注册
		if(userDao.queryUser(user.getLoginName())!=null){
			System.out.println("该用户已存在");
		}
		userDao.addUser(user);
	}

	@Override
	public User login(HttpServletRequest request,User user) throws Exception {     //登录
		User user2 = userDao.queryUser(user.getLoginName());
		if(user2==null){
			System.out.println("用户不存在  登录失败");
		}else{
			if(user2.getLoginName().equals(user.getLoginName()) 
				&& user2.getuPassword().equals(user.getuPassword())){
				HttpSession session = request.getSession();
				session.setAttribute("user", user2);
				System.out.println("发出登录用户名："+user2);
				return user;
			}
			else{
				System.out.println("账号或密码错误  登录失败");
			}
		}
		return null;
	}

	@Override
	public void deleteUser(int id) throws Exception {
		User user2 = userDao.queryUserById(id);
		if(user2!=null){
			userDao.deleteUser(user2);
		}
	}
	/**
	 * 修改用户信息
	 */
	@Override
	public void updateUser(User user) throws Exception {
		User user2 = userDao.queryUserById(user.getId());
		if(user2 == null){
			System.out.println("用户不存在  无法修改用户·······");
		}else{
			user.setCreatedate(user2.getCreatedate());
			userDao.updateUser(user);
			System.out.println("用户修改成功");
		}
	}

	@Override
	public User queryUser(String name) throws Exception {
		User user = userDao.queryUser(name);
		if(user==null){
			System.out.println("用户不存在");
		}else{
			return user;
		}
		return null;
	}

	@Override
	public List<User> queryUserByTwo(String name, Integer status) throws Exception {
		List<User> lUsers = userDao.queryUserByTwo(name, status);
		if(lUsers.size()<=0){
			return null;
		}
		return lUsers;
	}

	@Override
	public List<User> listAll() throws Exception {
		List<User> list  = userDao.listAll();
		if(list!=null){
			return list;
		}
		return null;
	}

	@Override
	public User queryUserById(Integer id) throws Exception {
		User user = userDao.queryUserById(id);
		return user;
	}
}
