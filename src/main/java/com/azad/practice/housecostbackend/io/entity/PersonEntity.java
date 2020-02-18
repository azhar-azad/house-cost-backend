package com.azad.practice.housecostbackend.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String contactNo;

	@Column(nullable = true)
	private String salary;

	protected PersonEntity() {
		super();
	}

	public PersonEntity(String personId, String email, String contactNo, String salary) {
		super();
		this.personId = personId;
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
