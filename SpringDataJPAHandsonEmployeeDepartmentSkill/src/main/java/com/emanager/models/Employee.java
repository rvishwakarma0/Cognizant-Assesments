package com.emanager.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
public class Employee {
	@NotNull(message = "Id cannot be null")
	@Positive(message = "Id should be positive number")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "em_id")
	private int id;
	
	@Size(min = 1, max = 30, message = "Name should be minimum 1 character and maximum 30 characters")
	@NotBlank(message = "Name cannot be blank")
	@NotNull(message = "Name cannot be null")
	@Column(name = "em_name")
    private String name;
	
	@NotNull(message = "Salary cannot be null")
	@PositiveOrZero(message = "Salary should be zero or above")
	@Column(name = "em_salary")
	private double salary;
	
	@NotNull(message = "permanent cannot be null")
	@Column(name = "em_permanent")
    private boolean permanent;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name = "em_date_of_birth")
    private Date dateOfBirth;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "em_dp_id")
	private Department department;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="employee_skill",
	joinColumns = @JoinColumn(name="es_em_id"),
	inverseJoinColumns = @JoinColumn(name="es_sk_id"))
	private Set<Skill> skillList;
	
	public Employee(String name, double salary, boolean permanent, Date dateOfBirth) {
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.department = null;
		this.skillList = new HashSet<>();
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public Set<Skill> getSkillList() {
		return skillList;
	}
	public void addSkill(Skill s) {
		this.skillList.add(s);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", skillSet=" + skillList + "]";
	}
	public Employee() {
	
	}	

}
