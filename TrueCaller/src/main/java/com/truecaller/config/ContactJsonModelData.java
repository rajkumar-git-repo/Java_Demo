package com.truecaller.config;

import java.util.List;

import org.springframework.stereotype.Component;

import com.truecaller.model.ContactJsonModel;

@Component
public class ContactJsonModelData {

	private List<ContactJsonModel> contactJsonModelList;

	public List<ContactJsonModel> getContactJsonModelList() {
		return contactJsonModelList;
	}

	public void setContactJsonModelList(List<ContactJsonModel> contactJsonModelList) {
		this.contactJsonModelList = contactJsonModelList;
	}

	@Override
	public String toString() {
		return "ContactJsonModelData [contactJsonModelList=" + contactJsonModelList + "]";
	}
}
