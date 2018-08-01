package com.qf.hrm.pojo;

import java.util.Date;

public class Notice {
	
	private int nId;
	private String nTitle;
	private String content;
	private Date nDate;
	private User user;
	
	public Notice() {}

	public Notice(String nTitle, String content) {
		super();
		this.nTitle = nTitle;
		this.content = content;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notice(int nId, String nTitle, String content, Date nDate, User user) {
		super();
		this.nId = nId;
		this.nTitle = nTitle;
		this.content = content;
		this.nDate = nDate;
		this.user = user;
	}

}
