package com.ordermanagement.ordertrackservice.controller;

import com.ordermanagement.ordertrackservice.model.ChangeOrderStatusRequest;
import com.ordermanagement.ordertrackservice.model.OrderDTO;
import com.ordermanagement.ordertrackservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-track")
@AllArgsConstructor
public class OrderTrackController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createNewOrder(@RequestBody OrderDTO order) {
        return ResponseEntity.ok().body(orderService.createOrder(order));
    }

    @PostMapping("/change-status")
    public ResponseEntity<Boolean> changeOrderStatusById(@RequestBody ChangeOrderStatusRequest request) {
        return ResponseEntity.ok().body(orderService.changeOrderStatus(request));
    }

}
