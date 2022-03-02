package com.emanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emanager.models.Department;
import com.emanager.models.Employee;
import com.emanager.services.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	@GetMapping("/")
	public List<Department> getAllDepartments() {
		return service.getAllDepartments();
	}
}
