package com.yh.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN_INFO")
public class AdminInfo implements Serializable{

	private static final long serialVersionUID = 6297817682226942858L;
	@Id
	@Column(name="ADMIN_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="admin_info_seq1")
	@SequenceGenerator(name="admin_info_seq1",sequenceName="ADMIN_SEQ",allocationSize=1,initialValue=1)
	private Integer adminId;
	@Column(name="ADMIN_CODE")
	private String adminCode;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="NAME")
	private String name;
	@Column(name="TELEPHONE")
	private String telephone;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ENROLLDATE")
	private String enrolldate;
	
	public AdminInfo(){}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(String enrolldate) {
		this.enrolldate = enrolldate;
	}

	@Override
	public String toString() {
		return "AdminInfo [adminId=" + adminId + ", adminCode=" + adminCode
				+ ", password=" + password + ", name=" + name + ", telephone="
				+ telephone + ", email=" + email + ", enrolldate=" + enrolldate
				+ "]";
	}
	
	
	
}








