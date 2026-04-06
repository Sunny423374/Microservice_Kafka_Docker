package com.Microservice.Service1.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private String customerId;
    private String status;
    private String orderDate;
    private int totalAmount;

}
