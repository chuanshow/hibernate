package com.qf.hrm.service;

import java.util.List;

import com.qf.hrm.pojo.Attendance;
import com.qf.hrm.pojo.Flows;
import com.qf.hrm.pojo.User;

public interface IFlowsServise {
	//添加流程
	public void addFlows (Flows flows )throws Exception;
	//删除流程
	public void deleteFlows(Integer fId)throws Exception;
	//查询所有流程
	public List<Flows> showFlows()throws Exception; 
	//查询个人流程
	public List<Flows> showOwnFlows(User user) throws Exception;
	//管理員審批查詢
	public List<Flows> showDoFlows()throws Exception;
	//模糊查询审批
	public List<Flows> selectFlows(String fName)throws Exception;
	//审批流程
	public void approvalFlows(Flows flows)throws Exception;
	//通过id查询流程
	public Flows findFlows(Integer flows)throws Exception;
	//模糊查询审批时流程
	public List<Flows> selectLikeFlows(String fName)throws Exception;
	//签到
	public void doAttendance(Attendance a)throws Exception;
	//通过flag查询考勤
	public Attendance findAttendance(String flag,String uName)throws Exception;
	//签退
	public void updateAttendance (Attendance a)throws Exception;
	//查询考勤（普通用户）
	public List<Attendance> showAttennce(String uName)throws Exception;
	//查询考勤(管理员用户)
	public List<Attendance> showAllAtendance()throws Exception;
	//模糊查询通过级别判断
	public List<Flows> selectFlowsByFlag(String fName,String uName)throws  Exception;
	//模糊查询考勤
	public List<Attendance>  showLikeAttendance(String uName)throws Exception;
}
