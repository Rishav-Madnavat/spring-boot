package com.jeriv.springboot.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Employee extends BaseEntity{
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String name;
}
