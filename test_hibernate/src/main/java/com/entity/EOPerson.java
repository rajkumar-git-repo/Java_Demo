package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EOPerson")
public class EOPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private String name;
	private String email;
	private int salary;
	@OneToMany(mappedBy = "eoPerson", cascade = CascadeType.ALL)
	private List<EOAddress> addresses;

	public EOPerson() {
		
	}
	
	public EOPerson(String name, String email, int salary) {
		super();
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<EOAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<EOAddress> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "EOPerson [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
}
