package com.ordermanagement.orderprocessingservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ordermanagement.orderprocessingservice.model.ChangeOrderStatusRequest;
import com.ordermanagement.orderprocessingservice.service.OrderProcessingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order-processing")
public class OrderProcessingController {

    private final OrderProcessingService orderProcessingService;

    @PostMapping
    public boolean changeOrderStatusById(@RequestBody ChangeOrderStatusRequest request) throws JsonProcessingException {
        return orderProcessingService.changeOrderStatusById(request.getOrderId(), request.getOrderStatus());
    }

}
