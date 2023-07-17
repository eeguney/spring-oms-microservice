package com.ordermanagement.orderprocessingservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ordermanagement.orderprocessingservice.model.Order;
import com.ordermanagement.orderprocessingservice.model.OrderStatusDTO;
import com.ordermanagement.orderprocessingservice.repository.OrderRepository;
import com.ordermanagement.orderprocessingservice.util.JsonConverterUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProcessingService {

    private final RedisTemplate<String, String> redisTemplate;
    private final OrderRepository orderRepository;
    private final JsonConverterUtil jsonConverterUtil;


    public boolean changeOrderStatusById(String orderId, OrderStatusDTO newStatus) throws JsonProcessingException {
        log.info("Changing order status - ID: " + orderId);
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isEmpty()) {
            log.info("There is no any order with this Id: " + orderId);
            return false;
        }
        order.get().setOrderStatus(newStatus);
        redisTemplate.boundValueOps("order-" + orderId).getAndSet(jsonConverterUtil.execute(order.get()));
        orderRepository.save(order.get());
        log.info("Order status changed successfully");
        return true;
    }

}
