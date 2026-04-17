package com.user.demo.dto;

import java.time.LocalDate;

import com.user.demo.entity.Gender;

public class UsersRequestDto {
	private String userName;
	private String email;
	private String password;
	private String mobile;
	private Gender gender;
	private String address;
	private LocalDate dod;
	private String dpurl;
	public UsersRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsersRequestDto(String userName, String email, String password, String mobile, Gender gender, String address,
			LocalDate dod, String dpurl) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.gender = gender;
		this.address = address;
		this.dod = dod;
		this.dpurl = dpurl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDod() {
		return dod;
	}
	public void setDod(LocalDate dod) {
		this.dod = dod;
	}
	public String getDpurl() {
		return dpurl;
	}
	public void setDpurl(String dpurl) {
		this.dpurl = dpurl;
	}
	@Override
	public String toString() {
		return "UsersRequestDto [userName=" + userName + ", email=" + email + ", password=" + password + ", mobile="
				+ mobile + ", gender=" + gender + ", address=" + address + ", dod=" + dod + ", dpurl=" + dpurl + "]";
	}
	
	
}
