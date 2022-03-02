package com.emanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanager.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
