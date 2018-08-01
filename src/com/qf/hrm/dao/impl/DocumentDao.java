package com.qf.hrm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qf.hrm.dao.IDocumentDao;
import com.qf.hrm.pojo.Document;
import com.qf.hrm.pojo.User;

@Repository
public class DocumentDao implements IDocumentDao{
	
	@Autowired
	private SessionFactory sessionFactory = null;

	@Override
	public void addDocument(Document document) throws Exception {
		sessionFactory.openSession().save(document);
	}

	@Override
	public void deleteDocument(Document document) throws Exception {
		sessionFactory.getCurrentSession().delete(document);
	}

	@Override
	public void updateDocument(Document document) throws Exception {
		sessionFactory.getCurrentSession().update(document);
	}

	@Override
	public List<Document> queryDocument(String  title) throws Exception {
		String sql = "select n from Document n where 1=1";
		if(title!=null){
			sql = sql+" and title='"+title+"'";
		}
		 Query query = sessionFactory.openSession().createQuery(sql);
		 List<Document> list = query.list();
		 return list.size()>0?list:null;
	}

	@Override
	public Document queryDocument(int id) throws Exception {
		return sessionFactory.openSession().get(Document.class, id);
	}

	@Override
	public List<Document> listAll() throws Exception {
		Query query = sessionFactory.openSession().createQuery("select n from Document n");
		List<Document> list = query.list();
		return list!=null?list:null;
	}
}
