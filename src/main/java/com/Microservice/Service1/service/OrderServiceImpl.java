package com.Microservice.Service1.service;

import com.Microservice.Service1.dto.OrderDto;
import com.Microservice.Service1.exception.ResourceNotFoundException;
import com.Microservice.Service1.model.Order;
import com.Microservice.Service1.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<Order> findAll() {
        return (orderRepo.findAll());
    }

    @Override
    public OrderDto findById(int id) {
        return modelMapper.map(orderRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order Not Found")),OrderDto.class);
    }

    @Override
    public OrderDto save(Order order) {
        return modelMapper.map(orderRepo.save(order),OrderDto.class);
    }

    @Override
    public OrderDto update(Order order) {
        Order updatedOrder = orderRepo.save(order);
        return modelMapper.map(updatedOrder,OrderDto.class);
    }

    @Override
    public OrderDto delete(int id) {
        Order order = orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Data not present with id: "+id));
        orderRepo.delete(order);
        return modelMapper.map(order,OrderDto.class);
    }
}
