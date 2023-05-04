package com.example.postgres.repository;

import com.example.postgres.Entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	List<EmployeeEntity> findByNameAndEmailId(String name, String emailId);

	Optional<EmployeeEntity> findByEmailId(String emailId);

}
