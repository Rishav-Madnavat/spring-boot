package com.jeriv.cabbook.models;

import com.jeriv.cabbook.dtos.UserDto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class User extends BaseInfo {

    public User(UserDto userDto){
        super(userDto);
    }

    public User() {
        
    }
    
}
