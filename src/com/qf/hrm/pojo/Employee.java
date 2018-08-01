package com.qf.hrm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	
	private Integer eId;
	private Dept dept;    //1   部门
	private Job job;   //1   职位
	private String eName;   //1  2
	private String cardId;  //身份证号码  1   2
	private String address;  //2
	private String postCode;  //邮编  2
	private String tel;  //2
	private String phone;  //1  2
	private String numQQ;//2
	private String email;//2
	private Integer sex;    //1  2
	private String party;  //政治面貌  2
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date birthday;   //2
	private String race;    //民 族    2
	private String education;   //学历    2
	private String speciality; //专业    2
	private String hobby;//2
	private String eRemark;   //备注   2
	@DateTimeFormat(pattern="yyyy-MM-dd")
 	private Date eDate;
	
	public Employee() {
	}
	
	public Employee(Dept dept, Job job, String eName, String cardId, String phone, Integer sex) {
		this.dept = dept;
		this.job = job;
		this.eName = eName;
		this.cardId = cardId;
		this.phone = phone;
		this.sex = sex;
	}
	
	
	
	
	
	public Employee(Integer eId, String eName, String cardId, String address, String postCode, String tel, String phone,
			String numQQ, String email, String party, String race, String education, String speciality,
			String hobby, String eRemark) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.cardId = cardId;
		this.address = address;
		this.postCode = postCode;
		this.tel = tel;
		this.phone = phone;
		this.numQQ = numQQ;
		this.email = email;
		this.party = party;
		this.race = race;
		this.education = education;
		this.speciality = speciality;
		this.hobby = hobby;
		this.eRemark = eRemark;
	}

	public Employee(Dept dept, Job job, String eName, String cardId, String address, String postCode, String tel,
			String phone, String numQQ, String email, Integer sex, String party, Date birthday, String race,
			String education, String speciality, String hobby, String eRemark, Date eDate) {
		super();
		this.dept = dept;
		this.job = job;
		this.eName = eName;
		this.cardId = cardId;
		this.address = address;
		this.postCode = postCode;
		this.tel = tel;
		this.phone = phone;
		this.numQQ = numQQ;
		this.email = email;
		this.sex = sex;
		this.party = party;
		this.birthday = birthday;
		this.race = race;
		this.education = education;
		this.speciality = speciality;
		this.hobby = hobby;
		this.eRemark = eRemark;
		this.eDate = eDate;
	}

	public Employee(Integer eId, Dept dept, Job job, String eName, String cardId, String address, String postCode,
			String tel, String phone, String numQQ, String email, Integer sex, String party, Date birthday, String race,
			String education, String speciality, String hobby, String eRemark, Date eDate) {
		super();
		this.eId = eId;
		this.dept = dept;
		this.job = job;
		this.eName = eName;
		this.cardId = cardId;
		this.address = address;
		this.postCode = postCode;
		this.tel = tel;
		this.phone = phone;
		this.numQQ = numQQ;
		this.email = email;
		this.sex = sex;
		this.party = party;
		this.birthday = birthday;
		this.race = race;
		this.education = education;
		this.speciality = speciality;
		this.hobby = hobby;
		this.eRemark = eRemark;
		this.eDate = eDate;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}
	
	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNumQQ() {
		return numQQ;
	}

	public void setNumQQ(String numQQ) {
		this.numQQ = numQQ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String geteRemark() {
		return eRemark;
	}

	public void seteRemark(String eRemark) {
		this.eRemark = eRemark;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}
 
	public Dept getDept() {
		return dept;
	}
 
	public void setDept(Dept dept) {
		this.dept = dept;
	} 
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", dept=" + dept + ", job=" + job + ", eName=" + eName + ", cardId=" + cardId
				+ ", address=" + address + ", postCode=" + postCode + ", tel=" + tel + ", phone=" + phone + ", numQQ="
				+ numQQ + ", email=" + email + ", sex=" + sex + ", party=" + party + ", birthday=" + birthday
				+ ", race=" + race + ", education=" + education + ", speciality=" + speciality + ", hobby=" + hobby
				+ ", eRemark=" + eRemark + ", eDate=" + eDate + "]";
	}

}
