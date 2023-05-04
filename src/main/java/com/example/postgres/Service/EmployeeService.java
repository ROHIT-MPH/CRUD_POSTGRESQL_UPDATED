package com.example.postgres.Service;

import com.example.postgres.Entity.EmployeeEntity;
//import com.example.postgres.Entity.DTO.EmployeeSearchDTO;
import com.example.postgres.Exception.EmployeeAlreadyExistsException;

import javassist.NotFoundException;

import java.util.List;


public interface EmployeeService {
	
	List<EmployeeEntity> getAllEmployees();

	EmployeeEntity getEmployeeById(Integer employeeId) throws NotFoundException;

	EmployeeEntity createEmployee(EmployeeEntity employee)throws EmployeeAlreadyExistsException;

	EmployeeEntity updateEmployee(Integer employeeId, EmployeeEntity employeeDetails);

	void deleteEmployee(Integer employeeId);

	List<EmployeeEntity> searchEmployees(String name, String emailId);


}