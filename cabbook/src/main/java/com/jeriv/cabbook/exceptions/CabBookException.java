package com.jeriv.cabbook.exceptions;

import lombok.Getter;

@Getter
public class CabBookException extends RuntimeException {

    private String errorMessage;
    private int httpStatusCode;

    public CabBookException (String message, int httpStatusCode) {
        this.errorMessage = message;
        this.httpStatusCode = httpStatusCode;       
    }

    public CabBookException (String message) {
        this.errorMessage = message;
        this.httpStatusCode = 500;
    }

    public CabBookException () {
        this.errorMessage = "Your request cannot proceed further. We are extremely sorry for the inconvience caused at the moment!";
        this.httpStatusCode = 500;
    }
}
