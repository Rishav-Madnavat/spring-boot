package com.jeriv.cabbook.dtos;

import lombok.Getter;

@Getter
public class SuccessDto {

    private Object data;
    private String message;

    public SuccessDto(Object data, String message) {
        this.data = data;
        this.message = message;
    }
}
