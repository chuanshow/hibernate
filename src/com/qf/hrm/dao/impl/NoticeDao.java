package com.qf.hrm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qf.hrm.dao.INoticeDao;
import com.qf.hrm.pojo.Notice;

@Repository
public class NoticeDao implements INoticeDao {
	
	@Autowired
	private SessionFactory sessionFactory = null;
	
	@Override
	public void addNotice(Notice notice) throws Exception {
		sessionFactory.openSession().save(notice);
	}

	@Override
	public void deleteNotice(Notice notice) throws Exception {
		sessionFactory.getCurrentSession().delete(notice);
	}

	@Override
	public void updateNotice(Notice notice) throws Exception {
		sessionFactory.getCurrentSession().update(notice);
	}
	
	
	@Override
	public Notice queryById(int id) throws Exception {
		return sessionFactory.openSession().get(Notice.class, id);
	}
	
	
	@Override
	public List<Notice> queryByTow(String title, String content) throws Exception {
		String sql = "select n from Notice n where 1=1";
		if(title!=null && !"".equals(title)){
			sql = sql+" and nTitle='"+title+"'";
		}
		if(content!=null && !"".equals(content)){
			sql = sql + " and content='"+content+"'";
		}
		Query query = sessionFactory.openSession().createQuery(sql);
		List<Notice> list = query.list();
		if(list.size()<=0){
			return null;
		}else{
			return list;
		}
	}
	
	@Override
	public List<Notice> listAll() throws Exception {
		String sql = "select n from Notice n ";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		List<Notice> list = query.list();
		return list;
		
	}

}
