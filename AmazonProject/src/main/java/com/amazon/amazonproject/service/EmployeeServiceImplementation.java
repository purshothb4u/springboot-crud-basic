package com.amazon.amazonproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.amazonproject.entity.Employee;
import com.amazon.amazonproject.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeId(Integer Id) {
		
		return employeeRepository.findById(Id).orElseThrow(() -> new RuntimeException("Entity not found"));
	}

	@Override
	public String deleteEmployee(Integer Id) {
	
		employeeRepository.deleteById(Id);
		
		return "Delete successfully";
	}

	@Override
	public Employee updateEmployee(Integer Id, Employee employee) {
		Optional<Employee> existingEmployee = employeeRepository.findById(Id);
		if(existingEmployee.isPresent()) {
			Employee employeeUpdated = existingEmployee.get();
			employeeUpdated.setName(employee.getName());
			employeeUpdated.setAge(employee.getAge());
			employeeUpdated.setRole(employee.getRole());
			return employeeRepository.save(employeeUpdated);
		}
		else {
			throw new RuntimeException("Entity not found");
		}
		
	}

}
