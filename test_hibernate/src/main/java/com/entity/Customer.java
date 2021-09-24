package com.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_id")
	private int custId;
	@Column(name="cust_name")
	private String custName;
	@Column(name="cust_email")
	private String custEmail;
	
	@ElementCollection
	List<String> address;
	
	@ElementCollection
	@Column(name="cust_order")
	List<Order> orderList;
	
	@ElementCollection
	private Map<Integer, Order> map = new HashMap<Integer, Order>();

	public Customer() {
		
	}
	
	public Customer(String custName, String custEmail) {
		super();
		this.custName = custName;
		this.custEmail = custEmail;
	}

	public Customer(String custName, List<String> address, String custEmail) {
		super();
		this.custName = custName;
		this.custEmail = custEmail;
		this.address = address;
	}



	public Customer(String custName, String custEmail, List<Order> orderList) {
		this.custName = custName;
		this.custEmail = custEmail;
		this.orderList = orderList;
	}



	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}
	
	public Map<Integer, Order> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Order> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", address="
				+ address + ", orderList=" + orderList + ", map=" + map + "]";
	}
}
