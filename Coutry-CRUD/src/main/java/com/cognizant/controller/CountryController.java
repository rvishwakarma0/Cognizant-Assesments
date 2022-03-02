package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.model.Country;
import com.cognizant.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	CountryService service;

	@GetMapping("/")
	public List<Country> showCountries() {
		return service.getCountries();
	}

	@GetMapping("/{code}")
	public Country showCountry(@PathVariable("code") String code) throws CountryNotFoundException {
		return service.getCountryByCode(code);
	}

	@GetMapping("/find")
	public Country findCountry(@RequestParam("code") String code) throws CountryNotFoundException {
		return service.getCountryByCode(code);
	}
	@PostMapping("/addcountry")
	public Country addCountry(@Valid @RequestBody Country country){
		
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//		
//		Set<ConstraintViolation<Country>> violations = validator.validate(country);
//		List<String> errors = new ArrayList<String>();
//		
//		for (ConstraintViolation<Country> violation : violations) {
//		errors.add(violation.getMessage());
//		}
//		
//		if (!violations.isEmpty()) 
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
		
		return service.addCountry(country);
	}
	@PutMapping("/update")
	public Country updateCountry(@RequestBody Country country) throws CountryNotFoundException {
		return service.updateCountry(country);
	}

	@DeleteMapping("/{code}")
	public Country deleteCountry(@PathVariable String code) throws CountryNotFoundException {
		return service.deleteCountryByCode(code);
	}
}
