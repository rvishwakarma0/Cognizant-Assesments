package com.emanager.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanager.exceptions.EmployeeNotFoundException;
import com.emanager.models.Employee;
import com.emanager.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	
	public Employee get(int id) {
		return repository.findById(id).get();
	}
	
	@Transactional
	public Employee save(Employee e) {
		repository.save(e);
		return e;
	}
	
	public List<Employee> getAllPermanentEmployees(){
		return repository.getAllPermanentEmployees();
	}
	
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
	
	public Employee update(Employee e) throws EmployeeNotFoundException {
	 	Optional<Employee> optional = repository.findById(e.getId());
	 	if(optional.isPresent())
	 		repository.save(e);
	 	else
	 		throw new EmployeeNotFoundException();
	 	return e;
	}

	public Employee delete(int id) throws EmployeeNotFoundException {
		Optional<Employee> optional = repository.findById(id);
	 	if(optional.isPresent())
	 		repository.delete(optional.get());
	 	else
	 		throw new EmployeeNotFoundException();
	 	return optional.get();
	}
}
