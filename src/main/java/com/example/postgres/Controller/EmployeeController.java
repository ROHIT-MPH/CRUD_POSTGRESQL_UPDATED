package com.example.postgres.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.postgres.Entity.EmployeeEntity;
import com.example.postgres.Entity.DTO.EmployeeMapper;
import com.example.postgres.Entity.DTO.EmployeeSearchDTO;
import com.example.postgres.Exception.NotFoundException;
import com.example.postgres.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;


@Profile("dev")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Autowired
	private EmployeeMapper employeeMapper;


	@GetMapping("/get-all-employees")
	public List<EmployeeEntity> getAllEmployee() {
		List<EmployeeEntity> employees = employeeService.getAllEmployees();
		return employees;
	}

	@GetMapping("/get-employee/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeebyId(@PathVariable(value = "id") Integer employeeId) throws NotFoundException {
		EmployeeEntity employeeEntity = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeEntity);
	}

	
	@PostMapping("/create-employees")
	public EmployeeEntity createEmployee(@Valid @RequestBody EmployeeEntity employeeEntity) {
		return  employeeService.createEmployee(employeeEntity);
	}


	@PutMapping("/update-employees/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable(value = "id") Integer employeeId,
			@RequestBody EmployeeEntity employeeEntity) {
		EmployeeEntity updatedEmployee = employeeService.updateEmployee(employeeId, employeeEntity);
		return ResponseEntity.ok(updatedEmployee);}
	
	
	@DeleteMapping("/delete-employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/partial")
	public List<EmployeeSearchDTO> searchEmployees(
	        @RequestParam(name = "name", required = false) String name,
	        @RequestParam(name = "emailId", required = false) String emailId)
	{
	    List<EmployeeEntity> employees = employeeService.searchEmployees(name, emailId);
	    List<EmployeeSearchDTO> employeeDTOs = new ArrayList<>();
	    for (EmployeeEntity employee : employees) {
	        EmployeeSearchDTO dto = employeeMapper.toDTO(employee); // Using EmployeeMapper == convert EmployeeEntity to EmployeeSearchDTO
	        employeeDTOs.add(dto);
	    }
	    return employeeDTOs;
	}
}