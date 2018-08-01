package com.qf.hrm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qf.hrm.pojo.User;

public interface IUserService {
	
	/**
	 * 添加用户  注册用户
	 * @throws Exception
	 */
	public void register(User user)throws Exception;
	
	/**
	 * 用户登录  判断是否存在
	 * @throws Exception
	 */
	public User login(HttpServletRequest request,User user)throws Exception;
	
	/**
	 * 删除的方法
	 * @throws Exception
	 */
	public void deleteUser(int id)throws Exception;
	
	/**
	 * 修改的方法
	 * @throws Exception
	 */
	public void updateUser(User user)throws Exception;
	
	/**
	 * 通过登录名查找
	 * @throws Exception
	 */
	public User queryUser(String name)throws Exception;
	
	
	public User queryUserById(Integer id)throws Exception;
	
	/**
	 * 通过用户名和状态查询
	 * @param name
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List queryUserByTwo(String name,Integer satus)throws Exception;
	
	public List<User>  listAll()throws Exception;
}
