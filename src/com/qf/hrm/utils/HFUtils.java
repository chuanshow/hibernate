package com.qf.hrm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 就是我们Hibernate的一个帮助类
 * 这个只是对重复代码的抽取
 * */
public class HFUtils {
	private static SessionFactory sf = null;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	static{
		sf = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
	}
	//获取我们的session
	public  static Session getSession() {
		//获取这个session我们可以这样做
		//首先判断当前的线程是否已经拥有了session
		Session session = threadLocal.get();
		if(session !=null){
			return session;
		}
		//没有session的情况
		session  = sf.openSession();
		//将这个变量放置到线程的局部变量中去
		threadLocal.set(session);
		return session;
	}
	//关闭资源的方法
	public static  void close(){
		//判断是否有session
		Session session = threadLocal.get();
		if(session!=null){
			//首先要提交事务
			session.getTransaction().commit();
			//关闭资源
			session.close();
		}
		threadLocal.remove();
	}
	
}
