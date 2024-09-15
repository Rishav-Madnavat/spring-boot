package com.jeriv.cabbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeriv.cabbook.dtos.RequestRideDto;
import com.jeriv.cabbook.dtos.RouteRequestDto;
import com.jeriv.cabbook.dtos.SuccessDto;
import com.jeriv.cabbook.dtos.UserDto;
import com.jeriv.cabbook.services.DriverService;
import com.jeriv.cabbook.services.UserService;
import com.jeriv.cabbook.utils.URLs;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(value = {URLs.VERSION1+URLs.USER})
public class UserController {

    private UserService userService;
    private DriverService driverService;

    public UserController(UserService userService, DriverService driverService){
        this.userService = userService;
        this.driverService = driverService;
    }
    
    @PostMapping(URLs.ADD)    
    public ResponseEntity<?> onBoardUser(@Valid @RequestBody UserDto userDto){
         return new ResponseEntity<>(new SuccessDto(userService.addUser(userDto), "User on-boarded Successfully"), HttpStatus.OK);
    }

    @PutMapping("/requestRide")
    public ResponseEntity<?> requestRide(@Valid @RequestBody RequestRideDto requestRideDto) {
        return new ResponseEntity<>(new SuccessDto(driverService.requestRide(requestRideDto), "Ride Booked SuccessFully!"), HttpStatus.OK);
    }

    @PostMapping(URLs.GET+"/cabs")
    public ResponseEntity<?> findCabs(@Valid @RequestBody RouteRequestDto requestDto) {
        return new ResponseEntity<>(driverService.getCabs(requestDto), HttpStatus.OK);
    }
}
