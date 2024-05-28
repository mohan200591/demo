package com.example.demo.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.EmployeeBean;
import com.example.demo.bean.EmployeeTaxInfo;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeJpaRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeJpaRepository employeeJpaRepository;

	@Override
	public String saveEmployeeData(EmployeeBean employee) {

		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setEmail(employee.getEmail());
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		employeeEntity.setJoiningDate(employee.getJoiningDate());
		employeeEntity.setPhoneNumber(employee.getPhoneNumber());
		employeeEntity.setEmpSalary(employee.getEmpSalary());
		employeeJpaRepository.save(employeeEntity);
		return "success";
	}

	@Override
	public EmployeeTaxInfo getTaxInfo(Long employeeId) {

		Optional<EmployeeEntity> employeeEntityDetails = employeeJpaRepository.findById(employeeId);
		EmployeeTaxInfo taxInfo = null;
		if (employeeEntityDetails.isPresent()) {
			EmployeeEntity employeeEntity = employeeEntityDetails.get();
			taxInfo = new EmployeeTaxInfo();
			taxInfo.setFirstName(employeeEntity.getFirstName());
			taxInfo.setLastName(employeeEntity.getLastName());
			taxInfo.setEmployeeId(employeeEntity.getEmployeeId());
			taxInfo.setYearlySalary(calculateEmployeeSalary(employeeEntity.getEmpSalary(), employeeEntity.getJoiningDate()));
			// calculate tax:
			taxInfo.setEmployeeTax(taxAmountCalculataion(taxInfo.getYearlySalary()));
			taxInfo.setEmployeeCess(calculateCess(taxInfo.getYearlySalary()));
		}

		return taxInfo;

	}

	private double calculateEmployeeSalary(double employeeSalary, LocalDate joiningDate) {

		LocalDate currentDate = LocalDate.now();
		 LocalDate lastDayOfJoiningYear = LocalDate.of(joiningDate.getYear(), 12, 31);
		long monthsWorked = ChronoUnit.MONTHS.between(joiningDate, lastDayOfJoiningYear.plusMonths(1));

		return monthsWorked * employeeSalary;

	}

	private double calculateCess(double yearlySalary) {
		if (yearlySalary > 2500000) {
			return (yearlySalary - 2500000) * 0.02;
		}

		return 0;
	}

	public static double taxAmountCalculataion(double salary) {
		double tax = 0.0;
		if (salary > 1000000) {
			tax += (salary - 1000000) * 0.20;
			salary = 1000000;
		}

		if (salary > 500000) {
			tax += (salary - 500000) * 0.10;
			salary = 500000;
		}

		if (salary > 250000) {
			tax += (salary - 250000) * 0.05;
		}
		return tax;
	}

}
