package com.jeriv.cabbook.dtos;

import com.jeriv.cabbook.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserDto {

    @NotNull(message = "Please enter name")
    private String name;

    @NotNull(message = "Please enter email")
    @Email(message = "Please enter a valid email")
    private String emailId;

    @NotNull(message = "Please enter mobileNumber")
    @Size(min = 10, max = 10, message = "Please enter a valid mobile number")
    @Pattern(regexp = "\\d+", message = "Please enter a valid mobile number")
    private String mobileNumber;

    public UserDto(){

    }

    public UserDto(User user){
        this.name = user.getName();
        this.emailId = user.getEmailId();
        this.mobileNumber = user.getMobileNumber().toString();
    }
}
