package com.azad.practice.housecostbackend.ui.model.response;

import java.util.List;

public class PersonRest {

	private String personId;
	private String name;
	private String email;
	private String contactNo;
	private double salary;
	private List<BillRest> billEntityList;

	protected PersonRest() {
		super();
	}

	public PersonRest(String personId, String name, String email, String contactNo, double salary) {
		super();
		this.personId = personId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.salary = salary;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<BillRest> getBillEntityList() {
		return billEntityList;
	}

	public void setBillEntityList(List<BillRest> billEntityList) {
		this.billEntityList = billEntityList;
	}

}
