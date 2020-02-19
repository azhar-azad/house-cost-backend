package com.azad.practice.housecostbackend.ui.model.response;

public class MonthlyCostRest {

	private String costId;
	private double houseRent;
	private double housemaidSalary;
	private double internetBill;
	private double gasBill;
	private double electricityBill;
	private double bazaar;

	protected MonthlyCostRest() {
		super();
	}

	public MonthlyCostRest(String costId, double houseRent, double housemaidSalary, double internetBill, double gasBill,
			double electricityBill, double bazaar) {
		super();
		this.costId = costId;
		this.houseRent = houseRent;
		this.housemaidSalary = housemaidSalary;
		this.internetBill = internetBill;
		this.gasBill = gasBill;
		this.electricityBill = electricityBill;
		this.bazaar = bazaar;
	}

	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}

	public double getHouseRent() {
		return houseRent;
	}

	public void setHouseRent(double houseRent) {
		this.houseRent = houseRent;
	}

	public double getHousemaidSalary() {
		return housemaidSalary;
	}

	public void setHousemaidSalary(double housemaidSalary) {
		this.housemaidSalary = housemaidSalary;
	}

	public double getInternetBill() {
		return internetBill;
	}

	public void setInternetBill(double internetBill) {
		this.internetBill = internetBill;
	}

	public double getGasBill() {
		return gasBill;
	}

	public void setGasBill(double gasBill) {
		this.gasBill = gasBill;
	}

	public double getElectricityBill() {
		return electricityBill;
	}

	public void setElectricityBill(double electricityBill) {
		this.electricityBill = electricityBill;
	}

	public double getBazaar() {
		return bazaar;
	}

	public void setBazaar(double bazaar) {
		this.bazaar = bazaar;
	}

}
