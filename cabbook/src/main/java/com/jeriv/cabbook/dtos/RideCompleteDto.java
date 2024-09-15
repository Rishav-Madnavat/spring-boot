package com.jeriv.cabbook.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RideCompleteDto {

    @NotNull(message = "Please enter email")
    @Email(message = "Please enter a valid email")
    private String emailId;
    @NotNull(message = "location is not specified")
    private double currentLat;
    @NotNull(message = "location is not specified")
    private double currentLong;
    
}
