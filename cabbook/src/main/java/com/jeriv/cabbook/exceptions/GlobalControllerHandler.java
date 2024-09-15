package com.jeriv.cabbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.jeriv.cabbook.dtos.ErrorResponseDto;

import java.util.*;

@RestControllerAdvice
public class GlobalControllerHandler {

    @ExceptionHandler(CabBookException.class)
    public ResponseEntity<?> cabBookException(CabBookException cbe) {
        return new ResponseEntity<>(new ErrorResponseDto(cbe.getErrorMessage(), cbe.getHttpStatusCode()), HttpStatus.valueOf(cbe.getHttpStatusCode()));
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<?> userExistsException(UserExistsException uee) {
        return new ResponseEntity<>(new ErrorResponseDto(uee.getErrorMessage(), uee.getHttpStatusCode()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException nfe) {
        return new ResponseEntity<>(new ErrorResponseDto(nfe.getErrorMessage(), nfe.getHttpStatusCode()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
