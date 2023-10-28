package com.jeriv.springboot.service.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeriv.springboot.dto.EmployeeDto;
import com.jeriv.springboot.entities.Employee;
import com.jeriv.springboot.entities.repository.EmployeeRepository;
import com.jeriv.springboot.mapper.EmployeeMapper;
import com.jeriv.springboot.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        try {
            Employee employee = employeeRepository.save(employeeEntityConversion(employeeDto));
            return employeeDtoConversion(employee);
        } catch (Exception e) {
            log.error("Error in adding employee --> ",e);
            return null;
        }
    }

    @Override
    public EmployeeDto updateEmployee(String uuid, EmployeeDto employeeDto) {

        try {
          Employee existingEmployee = employeeRepository.findByUuid(UUID.fromString(uuid)).orElseThrow(() -> new RuntimeException("Employee not found"));
          updateEmployee(employeeDto, existingEmployee);
          return employeeDtoConversion(employeeRepository.save(existingEmployee));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public EmployeeDto getEmployee(String uuid) {

        try {     
        Employee existingEmployee = employeeRepository.findByUuid(UUID.fromString(uuid)).orElseThrow(() -> new RuntimeException("Employee not found"));
        return employeeDtoConversion(existingEmployee);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::employeeDtoConversion).collect(Collectors.toList());    
    }

    @Override
    public String deleteEmployee(String uuid) {

        employeeRepository.deleteByUuid(UUID.fromString(uuid));
        return "Deleted Successfully";
    }

    private Employee employeeEntityConversion(EmployeeDto employeeDto){

        EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);
        return employeeMapper.toEmployee(employeeDto);
    }

    private EmployeeDto employeeDtoConversion(Employee employee){

        EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);
        return employeeMapper.toEmployeeDto(employee);
    }

    private void updateEmployee(EmployeeDto employeeDto, Employee employee){

        EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);
        employeeMapper.updateEmployee(employeeDto, employee);
    }
    
}
