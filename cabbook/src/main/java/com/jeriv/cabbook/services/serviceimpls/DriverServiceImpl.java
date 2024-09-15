package com.jeriv.cabbook.services.serviceimpls;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jeriv.cabbook.dtos.DriverDto;
import com.jeriv.cabbook.dtos.RequestRideDto;
import com.jeriv.cabbook.dtos.RideCompleteDto;
import com.jeriv.cabbook.dtos.RouteRequestDto;
import com.jeriv.cabbook.exceptions.CabBookException;
import com.jeriv.cabbook.exceptions.NotFoundException;
import com.jeriv.cabbook.exceptions.UserExistsException;
import com.jeriv.cabbook.models.Driver;
import com.jeriv.cabbook.services.DriverService;
import com.jeriv.cabbook.utils.Constants;
import com.jeriv.repositories.DriverRepository;
import com.jeriv.repositories.UserRespository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DriverServiceImpl implements DriverService {

    @Override
    public DriverDto onBoardDriver(DriverDto driverDto) {
        
        try {
            if(DriverRepository.drivers.containsKey(driverDto.getEmailId()) || UserRespository.users.containsKey(driverDto.getEmailId())) {
                throw new UserExistsException("Driver with this username already exists!");
            }

            if(DriverRepository.drivers.values().stream().anyMatch(driver -> driver.getMobileNumber().toString().equals(driverDto.getMobileNumber())) ||
            UserRespository.users.values().stream().anyMatch(driver -> driver.getMobileNumber().toString().equals(driverDto.getMobileNumber()))) {
                throw new UserExistsException("Provided Mobile Number is already registered!");
            }
            DriverRepository.drivers.put(driverDto.getEmailId(), new Driver(driverDto));
            log.info("Driver on-boared"+new Driver(driverDto));
            return driverDto;
        } catch (UserExistsException uee) {
            log.error("Exception in onBoarding Driver", uee.getErrorMessage());
            throw new UserExistsException(uee.getErrorMessage());    
        } catch (Exception e) {
            log.error("Exception in onBoarding Driver", e);
            throw new CabBookException();
        }
    }

    @Override
    public List<Driver> getCabs(RouteRequestDto routeRequestDto) {
        
        try {
            return DriverRepository.drivers.values().stream().filter(driver -> 
            calculateDistance(driver.getCurrentLat(), driver.getCurrentlong(), routeRequestDto.getSourceLat(), routeRequestDto.getSourceLong())<=routeRequestDto.getNearDis()
             && driver.getRideActive().equals(Boolean.FALSE)).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Exception in fetching cabs", e);
            throw new CabBookException();
        }
    }

    @Override
    public Driver requestRide(RequestRideDto requestRideDto) {

        try {
            if(!DriverRepository.drivers.containsKey(requestRideDto.getUserName())) {
                throw new NotFoundException("No Driver found!");
            }
            Driver driver = DriverRepository.drivers.get(requestRideDto.getUserName());

            if(driver.getRideActive().equals(Boolean.TRUE)){
                throw new NotFoundException("The requested ride is currently active!");
            }
            driver.setRideActive(Boolean.TRUE);
            DriverRepository.drivers.put(requestRideDto.getUserName(), driver);
            return DriverRepository.drivers.get(requestRideDto.getUserName());
        } catch (NotFoundException nfe) {
            log.error("Exception in confirming the ride: ", nfe);
            throw new NotFoundException(nfe.getErrorMessage());   
        } catch (Exception e) {
            log.error("Exception in confirming ride", e);
            throw new CabBookException();
        }
    }

    @Override
    public Boolean completeRide(RideCompleteDto rideCompleteDto) {

        try {
            if(!DriverRepository.drivers.containsKey(rideCompleteDto.getEmailId())) {
                throw new NotFoundException("No Log found for your entry!");
            }
            Driver driver = DriverRepository.drivers.get(rideCompleteDto.getEmailId());
            DriverRepository.drivers.put(driver.getEmailId(), new Driver(driver, rideCompleteDto));
            return Boolean.FALSE;
        } catch (NotFoundException nfe) {
            log.error("Exception in completing the ride: ", nfe);
            throw new NotFoundException(nfe.getErrorMessage());   
        } catch (Exception e) {
            log.error("Exception in completing the ride: ", e);
            throw new CabBookException();
        }
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return Constants.EARTH_RADIUS_KM * c;
    }  
}
