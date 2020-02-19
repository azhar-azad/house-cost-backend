package com.azad.practice.housecostbackend.ui.model.request;

public class BillDetailsRequestModel {

	private String name;
	private String amount;
	private int isActive;

	protected BillDetailsRequestModel() {
		super();
	}

	public BillDetailsRequestModel(String name, String amount, int isActive) {
		super();
		this.name = name;
		this.amount = amount;
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
