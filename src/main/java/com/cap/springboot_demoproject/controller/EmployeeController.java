package com.cap.springboot_demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.springboot_demoproject.dto.Employee;
import com.cap.springboot_demoproject.service.EmployeeService;
import com.cap.springboot_demoproject.util.ResponseStructure;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getEmployee(@PathVariable int id){
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<ResponseStructure<List<Employee>>> getAll(){
		return employeeService.getAll();
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee){
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable int id){
		return employeeService.deleteEmployee(id);
	}
}
