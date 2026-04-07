package com.Microservice.Service1.service;

import com.Microservice.Service1.dto.OrderDto;
import com.Microservice.Service1.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();
    OrderDto findById(int id);
    OrderDto save(Order order);
    OrderDto update(Order order, int id);
    OrderDto delete(int id);
}
