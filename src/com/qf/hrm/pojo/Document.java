package com.qf.hrm.pojo;

import java.util.Date;

public class Document {

	private Integer dId;
	private String title;
	private String fileName;
	private String dRemark;
	private Date dDate;
	private User user;
	
	public Document() {
	}
	
	public Document(Integer dId, String title, String fileName, String dRemark, Date dDate, User user) {
		super();
		this.dId = dId;
		this.title = title;
		this.fileName = fileName;
		this.dRemark = dRemark;
		this.dDate = dDate;
		this.user = user;
	}

	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getdRemark() {
		return dRemark;
	}
	public void setdRemark(String dRemark) {
		this.dRemark = dRemark;
	}
	public Date getdDate() {
		return dDate;
	}
	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "Document [dId=" + dId + ", title=" + title + ", fileName=" + fileName + ", dRemark=" + dRemark
				+ ", dDate=" + dDate + ", user=" + user + "]";
	}
	
}
