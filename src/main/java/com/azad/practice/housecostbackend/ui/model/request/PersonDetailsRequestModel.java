package com.azad.practice.housecostbackend.ui.model.request;

public class PersonDetailsRequestModel {

	private String name;
	private String email;
	private String contactNo;
	private String salary;

	protected PersonDetailsRequestModel() {
		super();
	}

	public PersonDetailsRequestModel(String name, String email, String contactNo, String salary) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.salary = salary;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
