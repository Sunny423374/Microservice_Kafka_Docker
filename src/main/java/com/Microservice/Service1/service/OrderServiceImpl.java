package com.Microservice.Service1.service;

import com.Microservice.Service1.dto.OrderDto;
import com.Microservice.Service1.exception.ResourceNotFoundException;
import com.Microservice.Service1.model.Order;
import com.Microservice.Service1.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;
    private final KafkaTemplate<Object, OrderDto> kafkaTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate2;

    @Override
    public List<Order> findAll() {
        kafkaTemplate2.send("topic3", "Data Fetched");
        return (orderRepo.findAll());
    }

    @Override
    public OrderDto findById(int id) {
        return modelMapper.map(orderRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order Not Found")),OrderDto.class);
    }

    @Override
    public OrderDto save(Order order) {

        kafkaTemplate.send("topic1",modelMapper.map(orderRepo.save(order),OrderDto.class));
        return modelMapper.map(orderRepo.save(order),OrderDto.class);
    }

    @Override
    public OrderDto update(Order order, int id) {
        Order orderData = orderRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not found"));
        orderData.setOrderDate(order.getOrderDate());
        orderData.setStatus(order.getStatus());
        orderData.setCustomerId(order.getCustomerId());
        orderData.setTotalAmount(order.getTotalAmount());
        orderRepo.save(orderData);

        kafkaTemplate.send("topic2",modelMapper.map(orderData,OrderDto.class));
        return modelMapper.map(orderData,OrderDto.class);
    }

    @Override
    public OrderDto delete(int id) {
        Order order = orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Data not present with id: "+id));
        orderRepo.delete(order);
        kafkaTemplate.send("topic1",modelMapper.map(order,OrderDto.class));
        return modelMapper.map(order,OrderDto.class);
    }
}
