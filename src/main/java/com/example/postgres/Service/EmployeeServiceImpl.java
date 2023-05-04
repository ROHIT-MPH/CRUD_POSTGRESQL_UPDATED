package com.example.postgres.Service;


import com.example.postgres.Entity.EmployeeEntity;
import com.example.postgres.Exception.EmployeeAlreadyExistsException;
import com.example.postgres.Exception.MethodArgumentException;
import com.example.postgres.Exception.NotFoundException;
import com.example.postgres.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired	
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee not found for this id :: " + employeeId));
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        validateEmployee(employee);
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeEntity updateEmployee(Integer employeeId, EmployeeEntity employeeDetails) {
        EmployeeEntity employee = getEmployeeById(employeeId);
        employee.setName(employeeDetails.getName());
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLocation(employeeDetails.getLocation());
        employee.setAge(employeeDetails.getAge());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        EmployeeEntity employee = getEmployeeById(employeeId);
        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeEntity> searchEmployees(String name, String emailId) {
        if (name != null && emailId != null) {
            return employeeRepository.findByNameAndEmailId(name, emailId);
        } else {
            return getAllEmployees();
        }
    }

  //business logic
    private void validateEmployee(EmployeeEntity employee) {
        if (employee.getName() == null) {
            throw new MethodArgumentException("Name is mandatory");
        }
        if (employee.getEmailId() == null) {
            throw new MethodArgumentException("Email is mandatory");
        }
        
        
        if (employee.getAge()<=0) {
            throw new MethodArgumentException("Invalid age");
        }
        
        if (!isValidEmail(employee.getEmailId())) {
            throw new MethodArgumentException("Invalid email format: " + employee.getEmailId());
        }
        if (employeeRepository.findByEmailId(employee.getEmailId()).isPresent()) {
            throw new EmployeeAlreadyExistsException("Employee already exists with email: " + employee.getEmailId());
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
