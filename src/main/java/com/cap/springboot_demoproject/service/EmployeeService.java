package com.cap.springboot_demoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cap.springboot_demoproject.dao.EmployeeDao;
import com.cap.springboot_demoproject.dto.Employee;
import com.cap.springboot_demoproject.exception.IdNotFoundException;
import com.cap.springboot_demoproject.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		Employee recievedEmployee = employeeDao.saveEmployee(employee);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(recievedEmployee);

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(int id) {
		Employee employee = employeeDao.getEmployeeById(id);
		if (employee != null) {
			ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new IdNotFoundException("Id not present");
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> getAll() {
		List<Employee> emplist = employeeDao.getAll();
		ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(emplist);

		return new ResponseEntity<ResponseStructure<List<Employee>>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee) {
		Employee updatedEmployee = employeeDao.saveEmployee(employee);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(updatedEmployee);

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");

		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
	}
}
