package com.qf.hrm.service;

import java.util.List;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;

import com.qf.hrm.pojo.Document;

public interface IDocumentService {
	/**
	 * 添加文件
	 * @throws Exception
	 */
	public void addDocument(HttpServletRequest request,Document document) throws Exception;
	
	/**
	 * 删除文件
	 * @throws Exception
	 */
	public void deleteDocument(int id) throws Exception;
	
	/**
	 * 修改文件
	 * @throws Exception
	 */
	public void updateDocument(Document document) throws Exception;
	
	/**
	 * 通过id查找文件   返回集合
	 * @throws Exception
	 */
	public Document queryDocumentById(int id) throws Exception;
	
	/**
	 * 通过标题查询
	 * @return
	 * @throws Exception
	 */
	public List<Document> queryByTitle(String title) throws Exception;
	
	/**
	 * 查找所有
	 * @return
	 * @throws Exception
	 */
	public List<Document>  listAll() throws Exception;
	
	
}
