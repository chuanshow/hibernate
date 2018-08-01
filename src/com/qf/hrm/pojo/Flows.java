package com.qf.hrm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Flows implements Serializable{
	private Integer fId;
	private String fName;
	private String context;
	private Integer uId;
	private Date time;
	private String sDate;
	private String eDate;
	private Integer state;
	private String uName;
	//拒絕理由
	private String reason;
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getsDate() {
		return sDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Flows [fId=" + fId + ", fName=" + fName + ", context=" + context + ", uId=" + uId + ", time=" + time
				+ "]";
	}
	
}
