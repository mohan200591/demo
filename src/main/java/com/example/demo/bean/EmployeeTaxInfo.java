package com.example.demo.bean;

import java.io.Serializable;

public class EmployeeTaxInfo implements Serializable{

	
	private String firstName;
	
	private String lastName;
	
	private double yearlySalary;
	
	private Long employeeId;
	
	private double employeeTax;
	
	private double employeeCess;

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

	public double getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public double getEmployeeTax() {
		return employeeTax;
	}

	public void setEmployeeTax(double employeeTax) {
		this.employeeTax = employeeTax;
	}

	public double getEmployeeCess() {
		return employeeCess;
	}

	public void setEmployeeCess(double employeeCess) {
		this.employeeCess = employeeCess;
	}

	@Override
	public String toString() {
		return "EmployeeTaxInfo [firstName=" + firstName + ", lastName=" + lastName + ", yearlySalary=" + yearlySalary
				+ ", employeeId=" + employeeId + ", employeeTax=" + employeeTax + ", employeeCess=" + employeeCess
				+ "]";
	}
	
	
}
