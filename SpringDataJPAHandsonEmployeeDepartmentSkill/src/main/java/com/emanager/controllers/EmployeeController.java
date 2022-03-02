package com.emanager.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emanager.exceptions.EmployeeNotFoundException;
import com.emanager.models.Employee;
import com.emanager.services.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	@PutMapping("/")
	public Employee updateEmployee(@Valid @RequestBody Employee e) throws EmployeeNotFoundException {
		Employee updatedEmployee = service.update(e);
		//return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
		return updatedEmployee;
	}
	@PostMapping("/")
	public Employee createEmployee(@Valid @RequestBody Employee e) {
	    Employee createdEmployee = service.save(e);
		return createdEmployee;
	}
	@DeleteMapping("/")
	public Employee deleteEmployee(@RequestParam("id") int id) throws EmployeeNotFoundException {
	    Employee deletedEmployee = service.delete(id);
		return deletedEmployee;	
	}
}
