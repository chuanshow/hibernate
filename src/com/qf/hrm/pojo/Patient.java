package com.qf.hrm.pojo;

import java.util.Date;

public class Patient {
	//住院号
		private String patient_number;
		//入院日期
		private Date inhos_date;
		private String card_id;
		private String customer_name;
		private String sex ;
		private String sectionoffice;
		private String bed_number;
		private String fault_name;
		private String customer_mobilephone;
		private String unit_work;
		private String commonality_name;
		private String medical_model;
		private String medical_caust;
		private String medical_state;
		private String patient_identification;
		private String occupation;
		
		
		public Patient(String patient_number, Date inhos_date, String card_id, String customer_name, String sex,
				String sectionoffice, String bed_number, String fault_name, String customer_mobilephone,
				String unit_work, String commonality_name, String medical_model, String medical_caust,
				String medical_state, String patient_identification, String occupation) {
			super();
			this.patient_number = patient_number;
			this.inhos_date = inhos_date;
			this.card_id = card_id;
			this.customer_name = customer_name;
			this.sex = sex;
			this.sectionoffice = sectionoffice;
			this.bed_number = bed_number;
			this.fault_name = fault_name;
			this.customer_mobilephone = customer_mobilephone;
			this.unit_work = unit_work;
			this.commonality_name = commonality_name;
			this.medical_model = medical_model;
			this.medical_caust = medical_caust;
			this.medical_state = medical_state;
			this.patient_identification = patient_identification;
			this.occupation = occupation;
		}
		public Patient() {
			super();
		}
		public String getPatient_number() {
			return patient_number;
		}
		public void setPatient_number(String patient_number) {
			this.patient_number = patient_number;
		}
		public Date getInhos_date() {
			return inhos_date;
		}
		public void setInhos_date(Date inhos_date) {
			this.inhos_date = inhos_date;
		}
		public String getCard_id() {
			return card_id;
		}
		public void setCard_id(String card_id) {
			this.card_id = card_id;
		}
		public String getCustomer_name() {
			return customer_name;
		}
		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getSectionoffice() {
			return sectionoffice;
		}
		public void setSectionoffice(String sectionoffice) {
			this.sectionoffice = sectionoffice;
		}
		public String getBed_number() {
			return bed_number;
		}
		public void setBed_number(String bed_number) {
			this.bed_number = bed_number;
		}
		public String getFault_name() {
			return fault_name;
		}
		public void setFault_name(String fault_name) {
			this.fault_name = fault_name;
		}
		public String getCustomer_mobilephone() {
			return customer_mobilephone;
		}
		public void setCustomer_mobilephone(String customer_mobilephone) {
			this.customer_mobilephone = customer_mobilephone;
		}
		public String getUnit_work() {
			return unit_work;
		}
		public void setUnit_work(String unit_work) {
			this.unit_work = unit_work;
		}
		public String getCommonality_name() {
			return commonality_name;
		}
		public void setCommonality_name(String commonality_name) {
			this.commonality_name = commonality_name;
		}
		public String getMedical_model() {
			return medical_model;
		}
		public void setMedical_model(String medical_model) {
			this.medical_model = medical_model;
		}
		public String getMedical_caust() {
			return medical_caust;
		}
		public void setMedical_caust(String medical_caust) {
			this.medical_caust = medical_caust;
		}
		public String getMedical_state() {
			return medical_state;
		}
		public void setMedical_state(String medical_state) {
			this.medical_state = medical_state;
		}
		public String getPatient_identification() {
			return patient_identification;
		}
		public void setPatient_identification(String patient_identification) {
			this.patient_identification = patient_identification;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		@Override
		public String toString() {
			return "Patient [patient_number=" + patient_number + ", inhos_date=" + inhos_date + ", card_id=" + card_id
					+ ", customer_name=" + customer_name + ", sex=" + sex + ", sectionoffice=" + sectionoffice
					+ ", bed_number=" + bed_number + ", fault_name=" + fault_name + ", customer_mobilephone="
					+ customer_mobilephone + ", unit_work=" + unit_work + ", commonality_name=" + commonality_name
					+ ", medical_model=" + medical_model + ", medical_caust=" + medical_caust + ", medical_state="
					+ medical_state + ", patient_identification=" + patient_identification + ", occupation="
					+ occupation + "]";
		}
		
		
}
