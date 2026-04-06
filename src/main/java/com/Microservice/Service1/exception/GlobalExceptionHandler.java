package com.Microservice.Service1.exception;

import com.Microservice.Service1.ApiError.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex){
        ApiError apiError = new ApiError();
        apiError.setMessage(ex.getMessage());
        apiError.setErrorCode("404sunny");
        apiError.setTimestamp(new Date());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

}
