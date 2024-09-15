package com.jeriv.cabbook.services;

import com.jeriv.cabbook.dtos.DriverDto;
import com.jeriv.cabbook.dtos.RequestRideDto;
import com.jeriv.cabbook.dtos.RideCompleteDto;
import com.jeriv.cabbook.dtos.RouteRequestDto;
import com.jeriv.cabbook.models.Driver;
import java.util.*;

public interface DriverService {

    DriverDto onBoardDriver(DriverDto driverDto);

    List<Driver> getCabs(RouteRequestDto routeRequestDto);

    Driver requestRide(RequestRideDto requestRideDto);

    Boolean completeRide(RideCompleteDto rideCompleteDto);
}
