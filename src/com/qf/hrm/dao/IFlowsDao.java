package com.qf.hrm.dao;

import java.util.List;

import com.qf.hrm.pojo.Attendance;
import com.qf.hrm.pojo.Flows;
import com.qf.hrm.pojo.User;

public interface IFlowsDao {
	//添加流程
	public void addFlows(Flows flows) throws Exception;
	//删除流程
	public void deleteFlows(Integer fId)throws Exception;
	//查询所有流程
	public List<Flows> showFlows()throws Exception;
	//查询当前登录用户的流程
	public List<Flows> showOwnFlow(User user )throws Exception;
	//管路員審批記錄
	public List<Flows> showDoFlow()throws Exception;
	//模糊查询审批记录
	public List<Flows> selectFlows(String fName)throws Exception;
	//模糊查詢区分用户级别
	public List<Flows> selectFlowsByFlag(String fName,String uName)throws Exception;
	//审批流程
	public void approvalFlows(Flows flows)throws Exception;
	//通过id查询流程
	public Flows findFlows(Integer fId)throws Exception;
	//模糊查询审批时的流程
	public List<Flows> selectLikeFlows(String fName)throws Exception;
	//签到
	public void doAttendance(Attendance a)throws Exception;
	//通过标识查询签到
	public Attendance findAttendance(String flag,String uName)throws Exception;
	//签退
	public void uodateAttendance(Attendance a)throws Exception;
	//查询考勤（普通用户）
	public List<Attendance> showAttennce(String uName)throws Exception;
	//查询考勤(管理员用户)
	public List<Attendance> showAllAtendance()throws Exception;
	//查询考勤(模糊查询)
	public List<Attendance>showLikeAttendance(String uName)throws Exception;
}
