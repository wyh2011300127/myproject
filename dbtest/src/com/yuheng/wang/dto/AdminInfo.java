package com.yuheng.wang.dto;

import java.io.Serializable;

public class AdminInfo implements Serializable{

	private static final long serialVersionUID = -8038822901567391376L;
	
	private Integer adminId;
	private String adminCode;
	private String password;
	private String name;
	private String telephone;
	private String email;
	private String enrollDate;
	public AdminInfo() {}
	public AdminInfo(Integer adminId, String adminCode, String password,
			String name, String telephone, String email, String enrollDate) {
		super();
		this.adminId = adminId;
		this.adminCode = adminCode;
		this.password = password;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.enrollDate = enrollDate;
	}
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
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "AdminInfo [adminId=" + adminId + ", adminCode=" + adminCode
				+ ", password=" + password + ", name=" + name + ", telephone="
				+ telephone + ", email=" + email + ", enrollDate=" + enrollDate
				+ "]";
	}
	
	
}
