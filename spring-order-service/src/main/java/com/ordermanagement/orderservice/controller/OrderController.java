package com.ordermanagement.orderservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ordermanagement.orderservice.model.Order;
import com.ordermanagement.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) throws JsonProcessingException {
        return ResponseEntity
                .ok()
                .body(orderService.createOrder(order));
    }

}
