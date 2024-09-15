package com.jeriv.cabbook.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RequestRideDto {

    private String vehicleNo;
    @NotNull(message = "Please enter username")
    @NotBlank(message = "Please enter username")
    @Email(message = "username is email, please enter a valid email")
    private String userName;
    private String driverName;
}
