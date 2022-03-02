package com.emanager.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "skill")
public class Skill {
	@NotNull(message = "Id cannot be null")
	@Positive(message = "Id should be positive number")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sk_id")
	private int id;
	
	
	@Size(min = 1, max = 30, message = "Name should be minimum 1 character and maximum 30 characters")
	@NotBlank(message = "Name cannot be blank")
	@NotNull(message = "Name cannot be null")
	@Column(name = "sk_name")
	private String name;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "skillList")
	private Set<Employee> employeeList;
	
	public Skill() {
		
	}

	public Skill(String name) {
		this.name = name;
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
	
	

	public Set<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
	

}
