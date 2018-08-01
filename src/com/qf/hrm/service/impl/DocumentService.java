package com.qf.hrm.service.impl;

import java.util.Date;
import java.util.List;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qf.hrm.dao.impl.DocumentDao;
import com.qf.hrm.pojo.Document;
import com.qf.hrm.pojo.User;
import com.qf.hrm.service.IDocumentService;

@Service
@Transactional
public class DocumentService implements IDocumentService{
	
	@Autowired
	private DocumentDao documentDao;

	@Override
	public void addDocument(HttpServletRequest request,Document document) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		document.setUser(user);
		document.setdDate(new Date());
		documentDao.addDocument(document);
	}

	@Override
	public void deleteDocument(int id) throws Exception {
		Document document = documentDao.queryDocument(id);
		if(document!=null){
			documentDao.deleteDocument(document);
		}
	}

	@Override
	public void updateDocument(Document document) throws Exception {
		Document document2 = documentDao.queryDocument(document.getdId());
		if(document2==null){
			System.out.println("不存在文档 不能修改");
			
			}
		else{
			document.setdDate(new Date());
			documentDao.updateDocument(document);
		}
	}

	@Override
	public Document queryDocumentById(int id) throws Exception {
		Document document = documentDao.queryDocument(id);
		return document!=null?document:null;
	}

	@Override
	public List<Document> queryByTitle(String title) throws Exception {
		List<Document> list = documentDao.queryDocument(title);
		return list;
	}

	@Override
	public List<Document> listAll() throws Exception {
		List<Document> list = documentDao.listAll();
		return list!=null?list:null;
	}
	
}
