package com.emanager;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.emanager.models.Department;
import com.emanager.models.Employee;
import com.emanager.models.Skill;
import com.emanager.services.*;

@SpringBootApplication
public class SpringDataJpaHandson2Application {
	
	static private Logger log = LoggerFactory.getLogger(SpringDataJpaHandson2Application.class);
	static private DepartmentService departmentService;
	static private EmployeeService employeeService;
	static private SkillService skillService;
	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaHandson2Application.class, args);
//		departmentService = ctx.getBean(DepartmentService.class);
//		employeeService = ctx.getBean(EmployeeService.class);
//		skillService = ctx.getBean(SkillService.class);
		//testGetEmployee();
		//testAddEmployee();
		//testUpdateEmployee();
		//testGetDepartment();
		//testAddSkill();
		//testGetPermanentEmployee();s
		//testAddEmployeeWithNoNewData();
	}
	
	/*
	 * private static void testAddEmployeeWithNoNewData() { log.info("Start");
	 * Employee employee = new Employee("test3 employee3",1200.90, true, new
	 * Date(12, 11, 1997));
	 * 
	 * 
	 * //getting department and skills Department department =
	 * departmentService.get(1); employee.setDepartment(department);
	 * 
	 * Skill s1 = skillService.get(1); Skill s2 = skillService.get(2); Skill s3 =
	 * skillService.get(3); employee.addSkill(s1); employee.addSkill(s2);
	 * employee.addSkill(s3); log.debug("Employee:{}", employee);
	 * employeeService.save(employee); log.debug("Employee:{}", employee);
	 * log.debug("Department:{}",employee.getDepartment()); log.info("End"); }
	 * 
	 * private static void testGetPermanentEmployee() { log.info("Start");
	 * List<Employee> permanentEmployees =
	 * employeeService.getAllPermanentEmployees();
	 * log.debug("Permanent Employees:{}", permanentEmployees); log.info("End"); }
	 * 
	 * private static void testAddSkill() { log.info("Start"); Employee employee =
	 * employeeService.get(1); log.debug("Employee:{}", employee); Skill s1 =
	 * skillService.get(4); Skill s2 = skillService.get(5);
	 * employee.addSkill(s1);employee.addSkill(s2); employeeService.save(employee);
	 * log.debug("Employee:{}", employee); log.info("End"); }
	 * 
	 * private static void testGetDepartment() { log.info("Start"); Department
	 * department = departmentService.get(2); //System.out.println(department);
	 * log.debug("Department:{}", department); log.debug("Employees:{}",
	 * department.getEmployeeList()); log.info("End"); }
	 * 
	 * private static void testUpdateEmployee() { log.info("Start"); Employee
	 * employee = employeeService.get(1); log.debug("Employee:{}", employee);
	 * Department department = departmentService.get(2);
	 * employee.setDepartment(department); employeeService.save(employee);
	 * log.debug("Employee:{}", employee); log.debug("Department:{}",
	 * employee.getDepartment()); log.info("End"); }
	 * 
	 * private static void testAddEmployee() { log.info("Start"); Department HR =
	 * new Department("HR Technical"); Skill java8 = new Skill("java8"); Skill html5
	 * = new Skill("html3"); skillService.save(html5);skillService.save(java8);
	 * departmentService.save(HR); Employee employee = new
	 * Employee("test4 employee5",1200.90, true, new Date(12, 10, 1999));
	 * employee.setDepartment(HR);
	 * 
	 * employee.addSkill(html5); employee.addSkill(java8);
	 * 
	 * log.debug("Employee:{}", employee); employeeService.save(employee);
	 * 
	 * log.debug("Employee:{}", employee);
	 * log.debug("Department:{}",employee.getDepartment()); log.info("End"); }
	 * 
	 * private static void testGetEmployee() { log.info("Start"); Employee employee
	 * = employeeService.get(1); log.debug("Employee:{}", employee);
	 * log.debug("Department:{}", employee.getDepartment()); log.info("End"); }
	 * 
	 */

}
