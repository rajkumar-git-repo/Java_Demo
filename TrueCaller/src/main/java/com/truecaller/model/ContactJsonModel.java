package com.truecaller.model;

import java.util.List;


public class ContactJsonModel {

	private String phone;
	private List<PersonJsonModel> contactList;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<PersonJsonModel> getContactList() {
		return contactList;
	}

	public void setContactList(List<PersonJsonModel> contactList) {
		this.contactList = contactList;
	}

	@Override
	public String toString() {
		return "ContactJsonModel [phone=" + phone + ", contactList=" + contactList + "]";
	}

}
