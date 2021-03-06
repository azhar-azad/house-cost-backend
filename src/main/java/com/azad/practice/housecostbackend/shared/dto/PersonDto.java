package com.azad.practice.housecostbackend.shared.dto;

import java.io.Serializable;
import java.util.List;

import com.azad.practice.housecostbackend.ui.model.response.BillRest;

public class PersonDto implements Serializable {

	private static final long serialVersionUID = 4008167047607290094L;

	private Long id;
	private String personId;
	private String name;
	private String email;
	private String contactNo;
	private double salary;
	private List<String> billNameList;
	private List<BillRest> billEntityList;

	protected PersonDto() {
		super();
	}

	public PersonDto(Long id, String personId, String name, String email, String contactNo, double salary) {
		super();
		this.id = id;
		this.personId = personId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<String> getBillNameList() {
		return billNameList;
	}

	public void setBillNameList(List<String> billNameList) {
		this.billNameList = billNameList;
	}

	public List<BillRest> getBillEntityList() {
		return billEntityList;
	}

	public void setBillEntityList(List<BillRest> billEntityList) {
		this.billEntityList = billEntityList;
	}

}
