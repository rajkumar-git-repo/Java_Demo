package com.truecaller.model;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginModel {

	@NotEmpty
	private String userName;

	public LoginModel() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
