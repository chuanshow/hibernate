package com.qf.hrm.dao;

import java.util.List;

import com.qf.hrm.pojo.Document;

public interface IDocumentDao {
	/**
	 * 添加文件
	 * @throws Exception
	 */
	public void addDocument(Document document) throws Exception;
	
	/**
	 * 删除文件
	 * @throws Exception
	 */
	public void deleteDocument(Document document) throws Exception;
	
	/**
	 * 修改文件
	 * @throws Exception
	 */
	public void updateDocument(Document document) throws Exception;
	
	/**
	 * 通过标题查找文件
	 * @throws Exception
	 */
	public List<Document> queryDocument(String title) throws Exception;
	
	/**
	 * 通过id查找文件
	 * @throws Exception
	 */
	public Document queryDocument(int id) throws Exception;
	
	/**
	 * 查询所有文档
	 * @return
	 * @throws Exception
	 */
	public List<Document> listAll() throws Exception;
}
