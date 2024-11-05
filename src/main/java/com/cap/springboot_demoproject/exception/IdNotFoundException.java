package com.cap.springboot_demoproject.exception;

public class IdNotFoundException extends RuntimeException {

	public IdNotFoundException() {
	}

	public IdNotFoundException(String msg) {
		super(msg);
	}

}
