package com.emanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emanager.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	@Query("Select e from Employee e left join fetch e.department d left join fetch e.skillList where e.permanent=1")
	List<Employee> getAllPermanentEmployees();
	
}
