package com.azad.practice.housecostbackend.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {

	private static final long serialVersionUID = -391745622317233745L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String personId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String contactNo;

	@Column(nullable = true)
	private double salary;

	@ManyToMany
	@JoinTable(name = "person_bill",
		joinColumns = @JoinColumn(name = "person_id"),
		inverseJoinColumns = @JoinColumn(name = "bill_id")
	)
	private List<BillEntity> billEntityList;

	protected PersonEntity() {
		super();
	}

	public PersonEntity(String personId, String name, String email, String contactNo, double salary) {
		super();
		this.personId = personId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.salary = salary;
	}

	public Long getId() {
		return id;
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

	public List<BillEntity> getBillEntityList() {
		return billEntityList;
	}

	public void setBillEntityList(List<BillEntity> billEntityList) {
		this.billEntityList = billEntityList;
	}

}
