package com.jeriv.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.jeriv.springboot.dto.EmployeeDto;
import com.jeriv.springboot.entities.Employee;

@Mapper 
public interface EmployeeMapper {
    
    Employee toEmployee(EmployeeDto employeeDto);

    EmployeeDto toEmployeeDto(Employee employee);

    Employee updateEmployee(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
