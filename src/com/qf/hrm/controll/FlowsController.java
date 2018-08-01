package com.qf.hrm.controll;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.hrm.pojo.Attendance;
import com.qf.hrm.pojo.Flows;
import com.qf.hrm.pojo.User;
import com.qf.hrm.service.IFlowsServise;
import com.qf.hrm.service.IUserService;
@Controller
public class FlowsController {
	@Resource
	private IFlowsServise flowsService;
	@Resource
	private IUserService userService;
	@RequestMapping("addFlows.action")
	public ModelAndView addFlows(HttpServletRequest request,Flows flows){
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(flows==null){
			return null;
		}
		try {
			flows.setState(1);
			flows.setuName(user.getUserName());
			flows.setuId(user.getId());
			flowsService.addFlows(flows);
		} catch (Exception e) {
			e.printStackTrace();
			model.setViewName("error");
		}
		model.setViewName("flows/addFlows");
		model.addObject(flows);
		return model;
	}
	@RequestMapping("deleteFlows.action")
	public ModelAndView deleteFlows(Integer fId){
		ModelAndView model = new ModelAndView();
		try {
			flowsService.deleteFlows(fId);
		} catch (Exception e) {
			e.printStackTrace();
			model.setViewName("error");
		}
		model.setViewName("flows/showFlows");
		return model;
	}
	@RequestMapping("showFlows.action")
	public ModelAndView showFlows(HttpServletRequest request){
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		List flows=null;
		try {
				if("1".equals(user.getFlag())){
			flows =flowsService.showFlows();
				}else{
					flows = flowsService.showOwnFlows(user);
				}
		} catch (Exception e) {
			e.printStackTrace();
			model.setViewName("error");
		}
		model.addObject("flows",flows);
		model.setViewName("flows/showFlows");
		return model;
	}
	//跳转至添加页面
	@RequestMapping("flows/addFlows.action")
	public ModelAndView addToFlows(){
		ModelAndView model = new ModelAndView();
		model.setViewName("flows/addFlows");
		return model;
	}
	@RequestMapping("flows/doFlows.action")
	public ModelAndView doFlows(){
		List flows=null;
		ModelAndView model = new ModelAndView();
		try {
			flows=flowsService.showDoFlows();
			model.addObject("flows",flows);
		} catch (Exception e) {
			e.printStackTrace();
			model.setViewName("error");
		}
		model.setViewName("flows/doFlows");
		return model;
	}
	@RequestMapping("flows/selectFlows.action")
	public ModelAndView selectFlows(String fName,HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		List flows=null;
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
			try {
				if("1".equals(user.getFlag())){
					flows =flowsService.selectFlows(fName);
				}else{
					flows=flowsService.selectFlowsByFlag(fName, user.getUserName());
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.setViewName("error");
			}
			model.addObject("flows",flows);
			model.setViewName("flows/showFlows");
		return model;
	}
	@RequestMapping("flows/approvalFlows.action")
	public ModelAndView approvalFlows(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		List flows=null;
		String flowsIds=request.getParameter("flowsId");
		String reason = request.getParameter("reason");
		String state = request.getParameter("state");
		String flowsId[] =flowsIds.split(",");
		for(int i=0;i<flowsId.length;i++){
			try {
				Flows flows1=flowsService.findFlows(Integer.valueOf(flowsId[i]));
				flows1.setState(Integer.valueOf(state));
				flows1.setReason(reason);
				flowsService.approvalFlows(flows1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			flows=flowsService.showDoFlows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("flows",flows);
		model.setViewName("flows/doFlows");
	return model;
	}
	@RequestMapping("flows/selectLikeFlows.action")
	public ModelAndView selectLikeFlows(String fName){
		ModelAndView model = new ModelAndView();
		List flows=null;
			try {
				if(null!=fName){
					flows =flowsService.selectLikeFlows(fName);
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.setViewName("error");
			}
			model.addObject("flows",flows);
			model.setViewName("flows/doFlows");
		return model;
	}
	@RequestMapping("flows/attendance.action")
	public ModelAndView attendance(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		Date nowDate=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String flag =sdf.format(nowDate);
		Attendance a= null;
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
		try {
			a =flowsService.findAttendance(flag,user.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
			model.setViewName("error");
		}
		if(a!=null){
			request.setAttribute("sDate", a.getsDate());
			request.setAttribute("eDate", a.geteDate());
		}
		model.setViewName("flows/attendance");
		return model;
	}
	
	@RequestMapping("flows/doAttendance.action")
	public String doAttendance(HttpServletRequest request){
		String sDate= request.getParameter("sDate");
		Date nowDate=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String flag =sdf.format(nowDate);
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
    	Attendance a= new Attendance();
    	a.setuName(user.getUserName());
    	a.setuId(user.getId());
    	a.setFlag(flag);
    	a.setsDate(sDate);
    	try {
			flowsService.doAttendance(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	request.setAttribute("sDate", a.getsDate());
    	return "flows/attendance";
	}
	@RequestMapping("flows/signBack.action")
	public String signBack(HttpServletRequest request){
		String eDate= request.getParameter("eDate");
		Date nowDate=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String flag =sdf.format(nowDate);
		Attendance a=null;
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
		try {
			a=flowsService.findAttendance(flag,user.getUserName());
			a.seteDate(eDate);
			a.setDay(1);
			flowsService.updateAttendance(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("sDate", a.getsDate());
		request.setAttribute("eDate", a.geteDate());
		return "flows/attendance";
	}
	@RequestMapping("flows/showAttendance.action")
	public ModelAndView showAttendance(HttpServletRequest request){
		HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
    	ModelAndView model = new ModelAndView();
    	List attendances=null;
    	try {
    	if("1".equals(user.getFlag())){
				attendances =flowsService.showAllAtendance();
    	}else{
    		attendances=flowsService.showAttennce(user.getUserName());
    	}
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	model.addObject("attendances",attendances);
    	model.setViewName("flows/showAttendance");
    	return model;
	}
	@RequestMapping("flows/authorization.action")
	public ModelAndView authorization(){
		ModelAndView model = new ModelAndView();
		List users = null;
		try {
			users =userService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("users",users);
		model.setViewName("user/authorization");
		return model;
	}
	@RequestMapping("flows/doAuthorization.action")
	public ModelAndView doAuthorization(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		String uId = request.getParameter("uIds");
		String[] uIds =uId.split(",");
		String [] idReason = request.getParameterValues("authorization");
		for(int i=0;i<uIds.length;i++){
			for(int j=0;j<idReason.length;j++){
				if(uIds[i].equals(idReason[j].split(",")[1])){
					try {
						User user =userService.queryUserById(Integer.valueOf(uIds[i]));
						user.setFlag(idReason[j].split(",")[0]);
						userService.updateUser(user);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		List users = null;
		try {
			users =userService.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addObject("users",users);
		model.setViewName("user/authorization");
		return model;
	}
	
	@RequestMapping("flows/slelectAttendance.action")
	public ModelAndView slelectAttendance(HttpServletRequest request,String uName){
    	ModelAndView model = new ModelAndView();
    	List attendances=null;
    	try {
    		attendances =flowsService.showLikeAttendance(uName);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	model.addObject("attendances",attendances);
    	model.setViewName("flows/showAttendance");
    	return model;
	}
}
