package com.cap.springboot_demoproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cap.springboot_demoproject.dto.Employee;
import com.cap.springboot_demoproject.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<Employee> getAll(){
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
	

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(int id) {
	   Optional<Employee> optional = employeeRepository.findById(id);
	   Employee emp = optional.get();
	    employeeRepository.delete(emp);
	}
}
