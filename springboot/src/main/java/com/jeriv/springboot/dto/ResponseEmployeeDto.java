package com.jeriv.springboot.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class ResponseEmployeeDto {
    
    private UUID uuid;
    private String name;
}
