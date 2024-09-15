package com.jeriv.cabbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeriv.cabbook.dtos.DriverDto;
import com.jeriv.cabbook.dtos.RideCompleteDto;
import com.jeriv.cabbook.dtos.SuccessDto;
import com.jeriv.cabbook.services.DriverService;
import com.jeriv.cabbook.utils.URLs;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(value = {URLs.VERSION1+URLs.DRIVER})
public class DriverController {

    private DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }
    
    @PostMapping(URLs.ADD)    
    public ResponseEntity<?> onBoardDriver(@Valid @RequestBody DriverDto driverDto){
        return new ResponseEntity<>(new SuccessDto(driverService.onBoardDriver(driverDto), "Driver on-boarded Successfully"), HttpStatus.OK);
    }

    @PostMapping("/completeRide")    
    public ResponseEntity<?> rideComplete(@Valid @RequestBody RideCompleteDto rideCompleteDto){
        return new ResponseEntity<>(new SuccessDto(driverService.completeRide(rideCompleteDto), "Ride completed successfully!"), HttpStatus.OK);
    }
}
