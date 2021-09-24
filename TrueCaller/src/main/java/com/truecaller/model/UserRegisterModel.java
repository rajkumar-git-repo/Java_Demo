package com.truecaller.model;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRegisterModel {

	@NotEmpty
	private String phoneNumber;

	@NotEmpty
	private String name;
	
	private String email;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserRegisterModel [phoneNumber=" + phoneNumber + ", name=" + name + ", email=" + email + "]";
	}
}
