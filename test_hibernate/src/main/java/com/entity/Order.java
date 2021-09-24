package com.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name="Order")
public class Order {

	@Column(name="item_name")
	private String itemName;
	@Column(name="status")
	private String status;
	
	public Order() {
		super();
	}
	
	public Order(String itemName, String status) {
		super();
		this.itemName = itemName;
		this.status = status;
	}



	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [itemName=" + itemName + ", status=" + status + "]";
	}
}
