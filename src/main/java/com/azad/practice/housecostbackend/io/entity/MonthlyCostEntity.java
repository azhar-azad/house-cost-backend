package com.azad.practice.housecostbackend.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monthly_cost")
public class MonthlyCostEntity implements Serializable {

	private static final long serialVersionUID = -6522395423979498446L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String costId;
	
	@Column(nullable = false)
	private double houseRent;
	
	@Column(nullable = false)
	private double housemaidSalary;
	
	@Column(nullable = false)
	private double internetBill;
	
	@Column(nullable = false)
	private double gasBill;
	
	@Column(nullable = false)
	private double electricityBill;
	
	@Column(nullable = false)
	private double bazaar;

	protected MonthlyCostEntity() {
		super();
	}

	public MonthlyCostEntity(String costId, double houseRent, double housemaidSalary, double internetBill,
			double gasBill, double electricityBill, double bazaar) {
		super();
		this.costId = costId;
		this.houseRent = houseRent;
		this.housemaidSalary = housemaidSalary;
		this.internetBill = internetBill;
		this.gasBill = gasBill;
		this.electricityBill = electricityBill;
		this.bazaar = bazaar;
	}

	public Long getId() {
		return id;
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
