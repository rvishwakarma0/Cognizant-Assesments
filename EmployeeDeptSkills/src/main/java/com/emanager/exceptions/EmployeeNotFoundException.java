package com.emanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND,reason = "Employee Not Found",code =HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException() {
	
	}

	public EmployeeNotFoundException(String message) {
		super(message);
		
	}

	
}
