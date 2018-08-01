package com.qf.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qf.hrm.dao.IFlowsDao;
import com.qf.hrm.pojo.Attendance;
import com.qf.hrm.pojo.Flows;
import com.qf.hrm.pojo.User;
import com.qf.hrm.service.IFlowsServise;
@Service
@Transactional
public class FlowsService implements IFlowsServise {
	@Autowired
	private IFlowsDao flowsDao=null; 
	@Override
	public void addFlows(Flows flows) throws Exception {
		
		flowsDao.addFlows(flows);
	}

	@Override
	public void deleteFlows(Integer fId) throws Exception {
		flowsDao.deleteFlows(fId);
	}

	@Override
	public List<Flows> showFlows() throws Exception {
		return flowsDao.showFlows();
	}

	@Override
	public List<Flows> showOwnFlows(User user) throws Exception {
		return flowsDao.showOwnFlow(user);
	}

	@Override
	public List<Flows> showDoFlows() throws Exception {
		
		return flowsDao.showDoFlow();
	}

	@Override
	public List<Flows> selectFlows(String fName) throws Exception {
		return flowsDao.selectFlows(fName);
	}

	@Override
	public void approvalFlows(Flows flows) throws Exception {
		flowsDao.approvalFlows(flows);
	}

	@Override
	public Flows findFlows(Integer flows) throws Exception {
		return flowsDao.findFlows(flows);
	}

	@Override
	public List<Flows> selectLikeFlows(String fName) throws Exception {
		return flowsDao.selectLikeFlows(fName);
	}

	@Override
	public void doAttendance(Attendance a) throws Exception {
		flowsDao.doAttendance(a);
	}

	@Override
	public Attendance findAttendance(String flag,String uName) throws Exception {
		return flowsDao.findAttendance(flag,uName);
	}

	@Override
	public void updateAttendance(Attendance a) throws Exception {
		flowsDao.uodateAttendance(a);
	}

	@Override
	public List<Attendance> showAttennce(String uName) throws Exception {
		return flowsDao.showAttennce(uName);
	}

	@Override
	public List<Attendance> showAllAtendance() throws Exception {
		return flowsDao.showAllAtendance();
	}

	@Override
	public List<Flows> selectFlowsByFlag(String fName, String uName) throws Exception {
		return flowsDao.selectFlowsByFlag(fName, uName);
	}

	@Override
	public List<Attendance> showLikeAttendance(String uName) throws Exception {
		return flowsDao.showLikeAttendance(uName);
	}

}
