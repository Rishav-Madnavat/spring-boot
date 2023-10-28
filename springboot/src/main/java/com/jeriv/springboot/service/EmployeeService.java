package com.jeriv.springboot.service;

import java.util.List;

import com.jeriv.springboot.dto.EmployeeDto;

public interface EmployeeService {
    
    EmployeeDto addEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(String uuid, EmployeeDto employeeDto);

    EmployeeDto getEmployee(String uuid);
    
    List<EmployeeDto> getAllEmployee();

    String deleteEmployee(String uuid);
}
