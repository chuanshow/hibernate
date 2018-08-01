package com.qf.hrm.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qf.hrm.dao.IFlowsDao;
import com.qf.hrm.pojo.Attendance;
import com.qf.hrm.pojo.Flows;
import com.qf.hrm.pojo.User;
@Repository
public class FlowsDao implements IFlowsDao {
	@Autowired
	private SessionFactory sessionFactory = null;
	
	@Override
	public void addFlows(Flows flows) throws Exception {
		sessionFactory.getCurrentSession().save(flows);
	}

	@Override
	public void deleteFlows(Integer fId) throws Exception {
		sessionFactory.getCurrentSession().delete(fId);
	}

	@Override
	public List<Flows> showFlows() throws Exception {
		String hql = "from Flows f where 1=1";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<Flows> showOwnFlow(User user ) throws Exception {
		String hql ="from Flows f where f.uId="+user.getId();
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<Flows> showDoFlow() throws Exception {
		String hql="from Flows f where f.state=1";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<Flows> selectFlows(String fName) throws Exception {
				String hql="from Flows f where f.fName like'%"+fName+"%'";
				return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public void approvalFlows(Flows flows) throws Exception {
		 sessionFactory.getCurrentSession().update(flows);
	}

	@Override
	public Flows findFlows(Integer fId) throws Exception {
		String hql="from Flows f where f.fId="+fId;
		List list =sessionFactory.getCurrentSession().createQuery(hql).list();
		return (Flows) list.get(0);
	}

	@Override
	public List<Flows> selectLikeFlows(String fName) throws Exception {
		String hql="from Flows f where f.fName like'%"+fName+"%'"+"and"+" f.state="+1;
		return sessionFactory.getCurrentSession().createQuery(hql).list();
		
	}

	@Override
	public void doAttendance(Attendance a) throws Exception {
		 sessionFactory.getCurrentSession().save(a);
	}

	@Override
	public Attendance findAttendance(String flag,String uName) throws Exception {
		String hql = "from Attendance a where a.Flag="+flag+" and a.uName='"+uName+"'";
		List list = sessionFactory.getCurrentSession().createQuery(hql).list();
		Attendance a= null;
		if(list.size()!=0){
			a=(Attendance) list.get(0);
		}
		return a;
	}

	@Override
	public void uodateAttendance(Attendance a) throws Exception {
		sessionFactory.getCurrentSession().update(a);
	}

	@Override
	public List<Attendance> showAttennce(String uName) throws Exception {
		String hql="from Attendance a where a.uName='"+uName+"' order by a.aId";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<Attendance> showAllAtendance() throws Exception {
		String hql="from Attendance a where 1=1 order by a.uId";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<Flows> selectFlowsByFlag(String fName, String uName) throws Exception {
		String hql="from Flows f where f.fName like'%"+fName+"%'"+" and f.uName='"+uName+"'";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	@Override
	public List<Attendance> showLikeAttendance(String uName) throws Exception {
		String hql="from Attendance f where 1=1 ";
		if(null!=uName){
			hql=hql+"and f.uName like '%"+uName+"%'" ;
		}
		hql =hql+" order by f.uId , f.aId";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

}
