package com.cap.springboot_demoproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cap.springboot_demoproject.util.ResponseStructure;

@ControllerAdvice()
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	public ResponseEntity<ResponseStructure<String>> catchIdNotFoundException(IdNotFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id not found");
		responseStructure.setData(PAGE_NOT_FOUND_LOG_CATEGORY);

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
}
