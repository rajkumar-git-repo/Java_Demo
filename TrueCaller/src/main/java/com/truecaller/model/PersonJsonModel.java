package com.truecaller.model;

public class PersonJsonModel {

	private String phoneNumber;
	private String personName;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Override
	public String toString() {
		return "PersonJsonModel [phoneNumber=" + phoneNumber + ", personName=" + personName + "]";
	}

}
