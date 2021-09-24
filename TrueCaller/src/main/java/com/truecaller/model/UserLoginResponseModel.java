package com.truecaller.model;

import java.util.List;

/**
 * @author Nikhilesh.Tiwari
 *
 */
public class UserLoginResponseModel {

	private String userName;
	private List<String> userRoles;
	private TokenModel tokenDetails;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}

	public TokenModel getTokenDetails() {
		return tokenDetails;
	}

	public void setTokenDetails(TokenModel tokenDetails) {
		this.tokenDetails = tokenDetails;
	}

	@Override
	public String toString() {
		return "UserLoginResponseModel [userName=" + userName + ", userRoles=" + userRoles + ", tokenDetails="
				+ tokenDetails + "]";
	}
}
