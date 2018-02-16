package com.github.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Employer {
	
	private int erId;
	
	@NotEmpty(message="Cannot be empty")
	private String companyName;
	
	@NotEmpty(message="Cannot be empty")
	private String address1;
	
	private String address2;
	
	@NotEmpty(message="Cannot be empty")
	private String city;
	
	@NotEmpty(message="Cannot be empty")
	private String state;
	
	@NotEmpty(message="Cannot be empty")
	private String postcode;
	
	@NotEmpty(message="Cannot be empty")
	@Email(message="Invalid Email Address")
	private String email;
	
	@NotEmpty(message="Cannot be empty")
	private String mobile;
	
	@NotEmpty
	private String password;
	
	public int getErId() {
		return erId;
	}
	public void setErId(int erId) {
		this.erId = erId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
