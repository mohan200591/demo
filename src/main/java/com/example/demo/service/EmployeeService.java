package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.bean.EmployeeBean;
import com.example.demo.bean.EmployeeTaxInfo;


public interface EmployeeService {

	String saveEmployeeData(EmployeeBean employee);

	 EmployeeTaxInfo getTaxInfo(Long employeeId);
	

}
