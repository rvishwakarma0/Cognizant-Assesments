package com.emanager.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "department")
public class Department {
	@NotNull(message = "Id cannot be null")
	@Positive(message = "Id should be positive number")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dp_id")
	private int id;
	
	@Size(min = 1, max = 30, message = "Name should be minimum 1 character and maximum 30 characters")
	@NotBlank(message = "Name cannot be blank")
	@NotNull(message = "Name cannot be null")
	@Column(name = "dp_name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private Set<Employee> employeeList = new HashSet<>();
	
	public Department(String name) {
		this.name = name;
	}

	public Department() {
		
	}

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public String toString() {
//		return "Department [id=" + id + ", name=" + name + "]";
//	}

	

	
	
	

}
