package com.jeriv.springboot.service;

import java.util.List;

import com.jeriv.springboot.dto.EmployeeDto;
import com.jeriv.springboot.dto.ResponseEmployeeDto;

public interface EmployeeService {
    
    ResponseEmployeeDto addEmployee(EmployeeDto employeeDto);

    ResponseEmployeeDto updateEmployee(String uuid, EmployeeDto employeeDto);

    ResponseEmployeeDto getEmployee(String uuid);
    
    List<ResponseEmployeeDto> getAllEmployee();

    String deleteEmployee(String uuid);
}
