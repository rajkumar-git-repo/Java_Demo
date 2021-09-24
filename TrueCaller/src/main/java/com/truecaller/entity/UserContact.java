package com.truecaller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "user_contact")
public class UserContact extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Version
	@Column(name = "version")
	private long version;

	@Id
	@Column(name = "contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;

	@Column(name = "phone_number", unique = true, nullable = false)
	private String phoneNumber;

	@Column(name = "name", length = 55, nullable = false)
	private String name;

	@Column(name = "is_User")
	private boolean isUser;
	
	@Column(name = "is_spam")
	private boolean isSpam;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

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

	public boolean isUser() {
		return isUser;
	}

	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}
	
	public boolean isSpam() {
		return isSpam;
	}

	public void setSpam(boolean isSpam) {
		this.isSpam = isSpam;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserContact [version=" + version + ", contactId=" + contactId + ", phoneNumber=" + phoneNumber
				+ ", name=" + name + ", isUser=" + isUser + ", isSpam=" + isSpam + ", user=" + user + "]";
	}
}
