package com.jeriv.cabbook.models;

import com.jeriv.cabbook.dtos.UserDto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class BaseInfo extends BaseEntity {

    private String name;
    private String emailId;
    private Long mobileNumber;

    public BaseInfo(UserDto userDto){
        super();
        this.name = userDto.getName();
        this.emailId = userDto.getEmailId();
        this.mobileNumber = Long.parseLong(userDto.getMobileNumber());
    }

    public BaseInfo() {
        
    }
}
