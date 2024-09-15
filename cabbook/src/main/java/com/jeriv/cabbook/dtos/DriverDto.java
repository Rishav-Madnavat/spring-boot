package com.jeriv.cabbook.dtos;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class DriverDto extends UserDto {

    @NotNull(message = "location is not specified")
    private double currentLat;
    @NotNull(message = "location is not specified")
    private double currentLong;
    @NotNull(message = "vehicle is not specified")
    private String vehicleNo;

    public DriverDto(){
         
    }
}
