package com.example.postgres.Entity.DTO;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.postgres.Entity.EmployeeEntity;

@Component
public class EmployeeMapper {

    @Autowired
    private ModelMapper modelMapper;

//    public EmployeeEntity toEntity(EmployeeSearchDTO employeeDTO) {
//        return modelMapper.map(employeeDTO, EmployeeEntity.class);
//    }

    public EmployeeSearchDTO toDTO(EmployeeEntity employeeEntity) {
        return modelMapper.map(employeeEntity, EmployeeSearchDTO.class);
    }
}
