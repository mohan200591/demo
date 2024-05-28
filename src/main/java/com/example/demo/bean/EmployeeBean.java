package com.example.demo.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.lang.NonNull;

public class EmployeeBean implements  Serializable{

	
	private Long employeeId;

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

	@NonNull
	private String email;

	@NonNull
	private String phoneNumber;

	@NonNull
	private LocalDate joiningDate;

	@NonNull
	private Double empSalary;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	
	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", joiningDate=" + joiningDate + ", empSalary="
				+ empSalary + "]";
	}
	
	
}
