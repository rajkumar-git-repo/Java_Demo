package com.truecaller.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.truecaller.enums.UserType;


@Entity
@Table(name = "user")
public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Version
	@Column(name = "version")
	private long version;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "phone_number", unique = true, length = 55,nullable = false)
	private String phoneNumber;

	@Column(name = "name", length = 55,nullable = false)
	private String name;
	
	@Column(name = "email", length = 55)
	private String email;
	
	@Column(name = "user_role", length = 50)
	@Enumerated(EnumType.STRING)
	private UserType userRole;
	
	@Column(name = "isActive")
	private boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserContact> userContactList;

	public User() {
		
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserType getUserRole() {
		return userRole;
	}

	public void setUserRole(UserType userRole) {
		this.userRole = userRole;
	}

	public List<UserContact> getUserContactList() {
		return userContactList;
	}

	public void setUserContactList(List<UserContact> userContactList) {
		this.userContactList = userContactList;
	}

	@Override
	public String toString() {
		return "User [version=" + version + ", userId=" + userId + ", phoneNumber=" + phoneNumber + ", name=" + name
				+ ", email=" + email + ", userRole=" + userRole + ", isActive=" + isActive + ", userContactList="
				+ userContactList + "]";
	}
}
