package com.amazon.amazonproject.service;

import java.util.List;

import com.amazon.amazonproject.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	 List<Employee> getEmployee();
	 
	 Employee getEmployeeId(Integer Id);
	 
	 String deleteEmployee(Integer Id);
	 
	 Employee updateEmployee(Integer Id, Employee employee);
}
