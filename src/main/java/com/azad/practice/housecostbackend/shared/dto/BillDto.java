package com.azad.practice.housecostbackend.shared.dto;

import java.io.Serializable;

public class BillDto implements Serializable {

	private static final long serialVersionUID = -8566368828425178433L;

	private Long id;
	private String billId;
	private String name;
	private double amount;
	private int isActive;

	protected BillDto() {
		super();
	}

	public BillDto(Long id, String billId, String name, double amount, int isActive) {
		super();
		this.id = id;
		this.billId = billId;
		this.name = name;
		this.amount = amount;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
