package com.cap.springboot_demoproject.util;

import java.util.List;

import com.cap.springboot_demoproject.dto.Employee;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	private int statusCode;
	private String message;
	private T data;
	
	
}
