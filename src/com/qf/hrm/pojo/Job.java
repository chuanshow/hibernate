package com.qf.hrm.pojo;

public class Job {
	
	private int jId;
	private String jName;
	private String jRemark;
	
	public Job() {
	}

	public Job(String jName, String jRemark) {
		super();
		this.jName = jName;
		this.jRemark = jRemark;
	}

	public Job(int jId, String jName, String jRemark) {
		this.jId = jId;
		this.jName = jName;
		this.jRemark = jRemark;
	}

	public int getjId() {
		return jId;
	}

	public void setjId(int jId) {
		this.jId = jId;
	}

	public String getjName() {
		return jName;
	}

	public void setjName(String jName) {
		this.jName = jName;
	}

	public String getjRemark() {
		return jRemark;
	}

	public void setjRemark(String jRemark) {
		this.jRemark = jRemark;
	}

	@Override
	public String toString() {
		return "Job [jId=" + jId + ", jName=" + jName + ", jRemark=" + jRemark + "]";
	}
	
}
