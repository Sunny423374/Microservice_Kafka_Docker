package com.Microservice.Service1.ApiError;

import lombok.Data;

import java.util.Date;

@Data
public class ApiError {
    private String message;
    private String errorCode;
    private Date timestamp;
}
