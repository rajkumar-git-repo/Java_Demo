package com.truecaller.model;

import org.hibernate.validator.constraints.NotEmpty;

public class UserUpdateModel {

	@NotEmpty
	private String phoneNumber;

	@NotEmpty
	private String email;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserUpdateModel [phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

}
