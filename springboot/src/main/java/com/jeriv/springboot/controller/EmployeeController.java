package com.jeriv.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeriv.springboot.dto.EmployeeDto;
import com.jeriv.springboot.dto.ResponseEmployeeDto;
import com.jeriv.springboot.service.EmployeeService;
import com.jeriv.springboot.utils.URLs;

@RestController
@RequestMapping(value = URLs.EMPLOYEE)
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    
    @PostMapping(value = URLs.ADD)
    public ResponseEntity<ResponseEmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.addEmployee(employeeDto), HttpStatus.CREATED);           
    }

    @PutMapping(value = URLs.UPDATE)
    public ResponseEntity<ResponseEmployeeDto> updateEmployee(@PathVariable String uuid, @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.updateEmployee(uuid,employeeDto), HttpStatus.CREATED);                      
    }

    @GetMapping(value = URLs.GET)
    public ResponseEntity<ResponseEmployeeDto> getEmployee(@PathVariable String uuid){
        return new ResponseEntity<>(employeeService.getEmployee(uuid), HttpStatus.OK);           
    }

    @GetMapping(value = URLs.ALL)
    public ResponseEntity<List<ResponseEmployeeDto>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);           
    }

    @DeleteMapping(value = URLs.DELETE)
    public ResponseEntity<String> deleteEmployee(@PathVariable String uuid){
        return new ResponseEntity<>(employeeService.deleteEmployee(uuid), HttpStatus.ACCEPTED);          
    }
}
