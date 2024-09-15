package com.jeriv.cabbook.exceptions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserExistsException extends RuntimeException {
    
    private String errorMessage;
    private int httpStatusCode;

    public UserExistsException () {
        super();
    }

    public UserExistsException (String message) {
        this.errorMessage = message;
        this.httpStatusCode = 400;
    }
}
