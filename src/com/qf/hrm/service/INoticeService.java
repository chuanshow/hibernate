package com.qf.hrm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qf.hrm.pojo.Notice;

public interface INoticeService {
	/**
	 * 添加公告
	 * @throws Exception
	 */
	public void addNotice(HttpServletRequest request,Notice notice)throws Exception;
	
	/**
	 * 通过id删除公告
	 * @throws Exception
	 */
	public void deleteNotice(int id)throws Exception;
	
	
	/**
	 * 修改公告
	 * @throws Exception
	 */
	public void updateNotice(HttpServletRequest request,Notice notice)throws Exception;
	
	
	/**
	 * 通过标题和内容查找查找公告
	 * @throws Exception
	 */
	public List<Notice> queryNoticeByTwo(String title,String content)throws Exception;
	
	
	/**
	 * 列出所有公告
	 * @return
	 * @throws Exception
	 */
	public List<Notice> listAll()throws Exception;
	
	
	public Notice queryById(Integer id)throws Exception;
}
