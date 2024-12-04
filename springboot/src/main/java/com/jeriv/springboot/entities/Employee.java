package com.jeriv.springboot.entities;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document()
public class Employee{
    
    @Id
    private UUID uuid = UUID.randomUUID();
    private String name;
}
