package com.azad.practice.housecostbackend.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class BillEntity implements Serializable {

	private static final long serialVersionUID = -6328748564940324702L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String billId;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private double amount;

	@Column(nullable = false)
	private int isActive;

	protected BillEntity() {
		super();
	}

	public BillEntity(String billId, String name, double amount, int isActive) {
		super();
		this.billId = billId;
		this.name = name;
		this.amount = amount;
		this.isActive = isActive;
	}
	
	public Long getId() {
		return id;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int isActive() {
		return isActive;
	}

	public void setActive(int isActive) {
		this.isActive = isActive;
	}

}
