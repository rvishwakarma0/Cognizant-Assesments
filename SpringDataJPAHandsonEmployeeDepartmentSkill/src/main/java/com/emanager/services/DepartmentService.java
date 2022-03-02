package com.emanager.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanager.models.Department;
import com.emanager.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repository;
	
	
	public Department get(int id) {
		return repository.findById(id).get();
		//return repository.getById(id);
	}
	
	@Transactional
	public void save(Department d) {
		repository.save(d);
	}

	public List<Department> getAllDepartments() {
		return repository.findAll();
	}
	
}
