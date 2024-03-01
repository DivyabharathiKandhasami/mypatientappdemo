package com.meeshomanage.demoenum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Transactional
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "pat")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "pa_id")
	private Long patientId;
	@Column(name = "pa_name")
	private String patientName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "phoneNo")
	private Long phoneNo;
	@Column(name = "Address")
	private String Address;
	@Column(name = "department")
	private String Department;
	@Column(name = "app_date")
	private String AppointDate;

	// getters and setters
	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getAppointDate() {
		return AppointDate;
	}

	public void setAppointDate(String appointDate) {
		AppointDate = appointDate;
	}

}
