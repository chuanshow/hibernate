package com.qf.hrm.controll;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.hrm.pojo.Notice;
import com.qf.hrm.service.impl.NoticeService;

@Controller
public class NoticeControll {
	
	@Resource
	private NoticeService noticeService;
	
	/**
	 * 公告查询
	 * @param request
	 * @param notice
	 * @return
	 */
	@RequestMapping("notice/selectNotice.action")
	public ModelAndView selectNotice(Notice notice){
		ModelAndView modelAndView = new ModelAndView();
		List<Notice> list = null;
		try {
			list = noticeService.queryNoticeByTwo(notice.getnTitle(), notice.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.setViewName("notice/notice");
		modelAndView.addObject("notices", list);
		return modelAndView;
	}
	
	/**
	 * 跳转至添加公告
	 * @param request
	 * @param notice
	 * @return
	 */
	@RequestMapping("notice/addNotice.action")
	public String addToNotice(){
		return "notice/showAddNotice";
	}
	
	/**
	 * 添加公告
	 * @param request
	 * @param notice
	 * @return
	 */
	@RequestMapping("notice/addNotice1.action")
	public ModelAndView addNotice(HttpServletRequest request,Notice notice){
		List<Notice> list = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			noticeService.addNotice(request, notice);
			list = noticeService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.setViewName("notice/notice");
		modelAndView.addObject("notices", list);
		return modelAndView;
	}
	
	
	
	/**
	 * 跳转至修改公告
	 * @param request
	 * @param notice
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("notice/updateNotice.action")
	public ModelAndView toUpdateNotice(Notice notice,Integer nId) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		Notice notice2 = noticeService.queryById(nId);
		modelAndView.addObject("notice", notice2);
		modelAndView.setViewName("notice/showUpdateNotice");
		return modelAndView;
	}
	/**
	 * 修改公告
	 * @param request
	 * @param notice
	 * @return
	 */
	@RequestMapping("notice/updateNotice1.action")
	public ModelAndView updateNotice(HttpServletRequest request,Notice notice){
		List<Notice> list = null;
		ModelAndView modelAndView = new ModelAndView();
		try {
			noticeService.updateNotice(request, notice);
			list = noticeService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.setViewName("notice/notice");
		modelAndView.addObject("notices", list);
		return modelAndView;
	}
	

	/**
	 * 删除公告
	 * @param request
	 * @param notice
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("notice/removeNotice.action")
	public ModelAndView deleteNotice(int[] ids) throws Exception{
		List<Notice> list = null;
		ModelAndView modelAndView = new ModelAndView();
			for(int id:ids){
				System.out.println(id);
				noticeService.deleteNotice(id);
			}
			list = noticeService.listAll();
		modelAndView.setViewName("notice/notice");
		modelAndView.addObject("notices", list);
		return modelAndView;
	}
	
	/**
	 * 预览公告
	 * @param request
	 * @param notice
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("notice/previewNotice.action")
	public ModelAndView previewNotice(Integer id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("notice/previewNotice");
		Notice notice =null;
		if(id!=null){
			notice =noticeService.queryById(id);
		}
		modelAndView.addObject("notice", notice);
		return modelAndView;
	}
	
	
}
