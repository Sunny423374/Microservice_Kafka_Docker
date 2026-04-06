package com.Microservice.Service1.dto;

import lombok.Data;

@Data
public class OrderDto {

    private String status;
    private String orderDate;
    private int totalAmount;
}
