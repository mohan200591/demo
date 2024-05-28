package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EmployeeEntity;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long>{

}
