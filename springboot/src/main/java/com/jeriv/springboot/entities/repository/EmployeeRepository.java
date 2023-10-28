package com.jeriv.springboot.entities.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeriv.springboot.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Optional<Employee> findByUuid(UUID uuid);
    
    void deleteByUuid(UUID uuid);
}
