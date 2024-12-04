package com.jeriv.springboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.jeriv.springboot.dto.EmployeeDto;
import com.jeriv.springboot.dto.ResponseEmployeeDto;
import com.jeriv.springboot.entities.Employee;

@Mapper 
public interface EmployeeMapper {
    
    Employee toEmployee(EmployeeDto employeeDto);

    ResponseEmployeeDto toEmployeeDto(Employee employee);

    Employee updateEmployee(EmployeeDto employeeDto, @MappingTarget Employee employee);
}
