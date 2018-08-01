package com.qf.hrm.dao;

import java.util.List;

import com.qf.hrm.pojo.User;

public interface IUserDao {
	
	/**
	 * 添加用户
	 * @throws Exception
	 */
	public void addUser(User user)throws Exception;
	
	/**
	 * 修改用户
	 * @throws Exception
	 */
	public void updateUser(User user)throws Exception;
	
	/**
	 * 删除用户
	 * @throws Exception
	 */
	public void deleteUser(User user)throws Exception;
	
	
	/**
	 * 通过登录名查找用户
	 * @throws Exception
	 */
	public User queryUser(String name)throws Exception;
	
	public User queryUserById(int id)throws Exception;
	
	/**
	 * 通过用户名和状态查找用户
	 * @throws Exception
	 */
	public List queryUserByTwo(String name,Integer status)throws Exception;
	
	public List<User>  listAll()throws Exception;
	
}
