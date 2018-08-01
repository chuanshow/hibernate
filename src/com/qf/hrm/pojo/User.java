package com.qf.hrm.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer id;
	private String loginName;
	private String uPassword;
	//是否审核通过成员
	private Integer uStatus;
	//是否管理员
	private String flag;
	private Date createdate;
	private String userName;
	private Set<Notice> notices = new HashSet<>();
	
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}
	public Set<Notice> getNotices() {
		return notices;
	}
	public User() {
		super();
	}
	
	public User(String loginName, String uPassword, Integer uStatus, String userName) {
		super();
		this.loginName = loginName;
		this.uPassword = uPassword;
		this.uStatus = uStatus;
		this.userName = userName;
	}
	public User(String userName) {
		super();
		this.userName = userName;
	}
	public User(Integer uStatus, String userName) {
		super();
		this.uStatus = uStatus;
		this.userName = userName;
	}
	public User(String loginName, String uPassword) {
		super();
		this.loginName = loginName;
		this.uPassword = uPassword;
	}
	public User(Integer id, String loginName, String uPassword, Integer uStatus, Date createdate, String userName) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.uPassword = uPassword;
		this.uStatus = uStatus;
		this.createdate = createdate;
		this.userName = userName;
	}

	public User(Integer id, String loginName, String uPassword, Integer uStatus, String flag, Date createdate,
			String userName, Set<Notice> notices) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.uPassword = uPassword;
		this.uStatus = uStatus;
		this.flag = flag;
		this.createdate = createdate;
		this.userName = userName;
		this.notices = notices;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public Integer getuStatus() {
		return uStatus;
	}

	public void setuStatus(Integer uStatus) {
		this.uStatus = uStatus;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", uPassword=" + uPassword + ", uStatus=" + uStatus
				+ ", flag=" + flag + ", createdate=" + createdate + ", userName=" + userName + ", notices=" + notices
				+ "]";
	}

	
}
