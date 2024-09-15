package com.jeriv.cabbook.models;

import com.jeriv.cabbook.dtos.DriverDto;
import com.jeriv.cabbook.dtos.RideCompleteDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
@Setter
public class Driver extends User {

    private double currentLat;
    private double currentlong;
    private String vehicleNo;
    private Boolean rideActive = Boolean.FALSE;

    public Driver(DriverDto driverDto){
        super(driverDto);
        this.currentLat = driverDto.getCurrentLat();
        this.currentlong = driverDto.getCurrentLong();
        this.vehicleNo = driverDto.getVehicleNo();
        this.rideActive = Boolean.FALSE;
    }

    public Driver(Driver driver, RideCompleteDto rideCompleteDto){
        this.currentLat = rideCompleteDto.getCurrentLat();
        this.currentlong = rideCompleteDto.getCurrentLong();
        this.vehicleNo = driver.getVehicleNo();
        this.rideActive = Boolean.FALSE;
    }
}
