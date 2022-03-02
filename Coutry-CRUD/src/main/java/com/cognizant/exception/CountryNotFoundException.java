package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND,reason = "Country Not Found",code =HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends Exception {

	public CountryNotFoundException() {
		super();
	
	}

	public CountryNotFoundException(String arg0) {
		super(arg0);
		
	}

}
