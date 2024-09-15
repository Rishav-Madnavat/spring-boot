package com.jeriv.cabbook.exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    
    private String errorMessage;
    private int httpStatusCode;

    public NotFoundException () {
        super();
    }

    public NotFoundException (String message) {
        this.errorMessage = message;
        this.httpStatusCode = 404;
    }
}
