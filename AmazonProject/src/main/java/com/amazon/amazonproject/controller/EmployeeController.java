package com.amazon.amazonproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.amazonproject.entity.Employee;
import com.amazon.amazonproject.service.EmployeeService;


@RestController
@RequestMapping("/amazonEmployee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/saveEmployee")
	public Employee postMethodName(@RequestBody Employee employee) {
		
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getMethodName() {
		return employeeService.getEmployee();
	}
	
	@GetMapping("/getById/{id}")
	public Employee getMethodName(@PathVariable Integer id) {
		return employeeService.getEmployeeId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		return employeeService.deleteEmployee(id);	
	}
	
	@PutMapping("updateById/{id}")
	public Employee putMethodName(@PathVariable Integer id, @RequestBody Employee employee) {	
		return employeeService.updateEmployee(id, employee);
	}
}
