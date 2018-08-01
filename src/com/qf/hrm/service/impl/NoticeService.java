package com.qf.hrm.service.impl;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qf.hrm.dao.INoticeDao;
import com.qf.hrm.dao.impl.NoticeDao;
import com.qf.hrm.pojo.Notice;
import com.qf.hrm.pojo.User;
import com.qf.hrm.service.INoticeService;

@Service
@Transactional
public class NoticeService implements INoticeService{
	
	@Autowired
	private NoticeDao noticeDao = null;
	
	@Override
	public void addNotice(HttpServletRequest request,Notice notice) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		notice.setUser(user);
		notice.setnDate(new Date());
		noticeDao.addNotice(notice);
	}

	@Override
	public void updateNotice(HttpServletRequest request,Notice notice) throws Exception {
		Notice notice2 = noticeDao.queryById(notice.getnId());
		if(notice2!=null){
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			System.out.println("接收登录用户名："+user);
			notice.setUser(user);
			notice.setnDate(notice2.getnDate());
			noticeDao.updateNotice(notice);
		}
	}
	
	@Override
	public void deleteNotice(int id) throws Exception {
		Notice notice = noticeDao.queryById(id);
		if(notice==null){
			System.out.println("不存在    无法删除");
		}else{
			noticeDao.deleteNotice(notice);
			System.out.println("删除成功");
		}
	}

	@Override
	public List<Notice> queryNoticeByTwo(String title, String content) throws Exception {
		List<Notice> list = noticeDao.queryByTow(title, content);
		if(list!=null){
			return list;
		}
		return null;
	}

	@Override
	public List<Notice> listAll() throws Exception {
		List<Notice> list = noticeDao.listAll();
		//if(list!=null){
			return list;
	//	}
	//	return null;
	}

	@Override
	public Notice queryById(Integer id) throws Exception {
		Notice notice = noticeDao.queryById(id);
		return notice;
	}
	
}
