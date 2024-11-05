package com.cap.springboot_demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.springboot_demoproject.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
