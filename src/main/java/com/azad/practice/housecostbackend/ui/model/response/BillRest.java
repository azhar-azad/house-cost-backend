package com.azad.practice.housecostbackend.ui.model.response;

public class BillRest {

	private String billId;
	private String name;
	private double amount;
	private boolean isActive;

	protected BillRest() {
		super();
	}

	public BillRest(String billId, String name, double amount, boolean isActive) {
		super();
		this.billId = billId;
		this.name = name;
		this.amount = amount;
		this.isActive = isActive;
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

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}
