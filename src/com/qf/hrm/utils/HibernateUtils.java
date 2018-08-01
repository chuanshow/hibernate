package com.qf.hrm.utils;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;

	/**
	 *功能类   实现增删改查   crud  对重复代码的抽取
	 * */
public class HibernateUtils {
	
	/**
	 * 保存的方法
	 */
	public static void save(Object object){
		Session session=HFUtils.getSession();
		session.beginTransaction();	
		session.save(object);
		HFUtils.close();
	}
	/**
	 * 删除的方法
	 * */
	public static void delete(Object object){
		Session session = HFUtils.getSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		session.close();
	}
	/**
	 * 修改的方法
	 * */
	public static void update(Object object){
		Session session = HFUtils.getSession();
		session.beginTransaction();
		session.update(object);
		HFUtils.close();
	}
	/**
	 *根据名字查询单个的方法
	 * */
//	public static <T> T query(String pname,Class clazz){
//		Session session = HFUtils.getSession();
////		session.beginTransaction();
//		 T t = (T) session.get(clazz, pname);
//		return t;
//	}
	/**
	 *根据id查询单个的方法
	 * */
	public static <T> T query2(int id,Class clazz){
		Session session = HFUtils.getSession();
//		session.beginTransaction();
		 T t = (T) session.get(clazz, id);
		return t;
	}
	/**
	 * 查询所有的方法
	 */
	public static List queryAllMessageBoard(){
		Session session= HFUtils.getSession();
		Query query = session.createQuery("select m from MessageBoard m");
		List list = query.list();
		return list;
	}
	
	public static List queryAllPerson(){
		Session session= HFUtils.getSession();
		Query query = session.createQuery("select m from Person m");
		List list=query.list();
		return list;
	}
	
	public static List queryAllPic(){
		Session session= HFUtils.getSession();
		Query query=session.createQuery("select p from Pic p ");
		List list = query.list();
		return list;
		
	}
	
	/**
	 * 通过用户名查询单个留言板
	 * @return 
	 */
	public static List queryMessageBoard(String pname){
		Session session= HFUtils.getSession();
		Query query = session.createQuery("select m from MessageBoard m where pname='"+pname+"'");
		List list = query.list();
		return list;
	}
	public static List queryPerson(String pname){
		Session session= HFUtils.getSession();
		Query query = session.createQuery("select m from Person m where pname='"+pname+"'");
		List list = query.list();
		return list;
	}

//	获取总条数
	public static  long queryCount(){
		Session session= HFUtils.getSession();
		  Query query=session.createQuery("select m from MessageBoard m");
        //分页:获取一共有所少数据
       ScrollableResults results=query.scroll();
       //表示的是滚动到末尾
       results.last();
       //下面就可以获取一共的数据条目数了
       long count=results.getRowNumber()+1;
       //打印我们的一共的数据条目数
       //System.out.println("获取到的一共的数据是:"+count);
       return count ;
	}
//	分页
	public static List queryByPage( int off,int limit){
		Session session= HFUtils.getSession();
        Query query=session.createQuery("select m from MessageBoard m order by mdate desc");
       query.setFirstResult(off);
       query.setMaxResults(limit);
       //接下来就应该查询数据了
       List list=query.list();
       System.out.println(list.size());
   
       return list;
      
	}
}
