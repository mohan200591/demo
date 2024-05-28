package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.EmployeeBean;
import com.example.demo.bean.EmployeeTaxInfo;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employeesave")
	public ResponseEntity<String> saveEMployeeDetails(@RequestBody EmployeeBean employee){
		
		return new ResponseEntity<String>(employeeService.saveEmployeeData(employee),HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeTaxInfo")
	public ResponseEntity<EmployeeTaxInfo> getEmployeeTaxDetails(@RequestParam("employeeId") Long employeeId){
		return new ResponseEntity<EmployeeTaxInfo>(employeeService.getTaxInfo(employeeId),HttpStatus.OK);
	}
	
}
