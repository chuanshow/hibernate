package com.qf.hrm.pojo;

public class Dept {
	
	private int dId;
	private String dName;
	private String dRemark;
	
	public Dept() {
	}
	
	public Dept(String dName) {
		super();
		this.dName = dName;
	}

	public Dept(String dName, String dRemark) {
		super();
		this.dName = dName;
		this.dRemark = dRemark;
	}

	public Dept(int dId, String dName, String dRemark) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dRemark = dRemark;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdRemark() {
		return dRemark;
	}

	public void setdRemark(String dRemark) {
		this.dRemark = dRemark;
	}

	@Override
	public String toString() {
		return "Dept [dId=" + dId + ", dName=" + dName + ", dRemark=" + dRemark + "]";
	}

}
