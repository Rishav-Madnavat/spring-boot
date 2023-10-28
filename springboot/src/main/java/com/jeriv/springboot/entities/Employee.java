package com.jeriv.springboot.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Employee extends BaseEntity{
    
    @UuidGenerator
    private UUID uuid;
    private String name;
}
