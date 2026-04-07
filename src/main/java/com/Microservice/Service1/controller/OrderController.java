package com.Microservice.Service1.controller;

import com.Microservice.Service1.dto.OrderDto;
import com.Microservice.Service1.model.Order;
import com.Microservice.Service1.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Order>> getAllOrders() {
        log.debug("REST request to get all Orders");
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") int id) {
        log.debug("REST request to get Order by id : {}", id);
        return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody Order order) {
        log.debug("REST request to save Order : {}", order);
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody Order order, @PathVariable int id) {
        log.debug("REST request to update Order : {}", order);
        return new ResponseEntity<>(orderService.update(order,id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrderDto> deleteOrderById(@PathVariable("id") int id) {
        log.debug("REST request to delete Order : {}", id);
        return new ResponseEntity<>(orderService.delete(id), HttpStatus.OK);
    }
}
