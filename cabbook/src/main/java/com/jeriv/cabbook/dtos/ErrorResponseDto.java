package com.jeriv.cabbook.dtos;

import lombok.Getter;

@Getter
public class ErrorResponseDto {

    private String message;
    private int httpStatusCode;

    public ErrorResponseDto(String message, int httpStatusCode) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
}
