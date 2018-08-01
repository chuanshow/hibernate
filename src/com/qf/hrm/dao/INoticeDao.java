package com.qf.hrm.dao;

import java.util.List;

import com.qf.hrm.pojo.Notice;

public interface INoticeDao {
	/**
	 * 添加公告
	 * @throws Exception
	 */
	public void addNotice(Notice notice)throws Exception;
	
	/**
	 * 删除公告
	 * @throws Exception
	 */
	public void deleteNotice(Notice notice)throws Exception;
	
	
	/**
	 * 修改公告
	 * @throws Exception
	 */
	public void updateNotice(Notice notice)throws Exception;
	
	
	/**
	 * 通过标题和内容查找公告
	 * @throws Exception
	 */
	public List<Notice> queryByTow(String title,String content)throws Exception;
	
	/**
	 * 查询所有公告
	 * @return
	 * @throws Exception
	 */
	public List<Notice> listAll()throws Exception;
	
	/**
	 * 通过Id查找公告
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Notice queryById(int id) throws Exception;
	
}
