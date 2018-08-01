package com.qf.hrm.pojo;

import java.io.Serializable;

public class Attendance implements Serializable{
	private Integer aId;
	private String sDate;
	private String eDate;
	private String uName;
	private String flag;
	private Integer uId;
	private Integer day;
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "Attendance [aId=" + aId + ", sDate=" + sDate + ", eDate=" + eDate + ", uName=" + uName + ", uId=" + uId
				+ ", day=" + day + "]";
	}
	
}
