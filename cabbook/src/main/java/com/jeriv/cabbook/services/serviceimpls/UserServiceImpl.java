package com.jeriv.cabbook.services.serviceimpls;


import org.springframework.stereotype.Service;

import com.jeriv.cabbook.dtos.UserDto;
import com.jeriv.cabbook.exceptions.CabBookException;
import com.jeriv.cabbook.exceptions.UserExistsException;
import com.jeriv.cabbook.models.User;
import com.jeriv.cabbook.services.UserService;
import com.jeriv.repositories.DriverRepository;
import com.jeriv.repositories.UserRespository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public UserDto addUser(UserDto userDto) {

        try {
            if(UserRespository.users.containsKey(userDto.getEmailId()) || DriverRepository.drivers.containsKey(userDto.getEmailId())){
                throw new UserExistsException("User with this username already exists!");
            }

            if(UserRespository.users.values().stream().anyMatch(user -> user.getMobileNumber().equals(userDto.getMobileNumber())) ||
            DriverRepository.drivers.values().stream().anyMatch(user -> user.getMobileNumber().equals(userDto.getMobileNumber()))) {
                throw new UserExistsException("Provided Mobile Number is already registered!");
            }
            UserRespository.users.put(userDto.getEmailId(), new User(userDto));
            log.info("User on-boared"+new User(userDto));
            return userDto;
        } catch (UserExistsException uee) {
            log.error("User's Attributes already present: ", uee.getErrorMessage());   
            throw new UserExistsException(uee.getErrorMessage());
        } catch (Exception e) {
            log.error("Exception in onBoarding User!", e);
            throw new CabBookException();
        }
    } 
}
