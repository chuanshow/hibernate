package com.qf.hrm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qf.hrm.dao.IUserDao;
import com.qf.hrm.pojo.User;
@Repository
public class UserDao implements IUserDao{
	
	@Autowired
	private SessionFactory sessionFactory = null;
	
	@Override
	public void addUser(User user) throws Exception {
		sessionFactory.openSession().save(user);
		
	}
	@Override
	public void updateUser(User user) throws Exception {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(User user) throws Exception {
		sessionFactory.getCurrentSession().delete(user);
	}
	/**
	 * 查询单个
	 */
	@Override
	public User queryUser(String name) throws Exception {
		 Query query = sessionFactory.openSession().createQuery("select n from User n where loginName='"+name+"'");
		 List<User> list = query.list();
		 if(list.size()>0){
			 User user = list.get(0);
			 return user;
		 }else{
			 return null;
		 }
	}
	@Override
	public List<User> queryUserByTwo(String name,Integer status) throws Exception {
		String sql = "select n from User n where 1=1";
		if(name!=null && !"".equals(name)){
			sql=sql+" and userName like '"+"%"+name+"%"+"'";
		}
		if(status!=null){
			sql = sql+" and uStatus="+status;
		}
		System.out.println(sql);
		Query query = sessionFactory.openSession().createQuery(sql);
		List<User> list = query.list();
		if(list.size()<=0){
			return null;
		}else{
			return list;
		}
	}
	@Override
	public User queryUserById(int id) throws Exception {
		return sessionFactory.openSession().get(User.class, id);
	}
	@Override
	public List<User> listAll() throws Exception {
		String sql = "select n from User n ";
		Query query = sessionFactory.openSession().createQuery(sql);
		List<User> list = query.list();
		if(list.size()<=0){
			return null;
		}else{
			return list;
		}
	}
}
