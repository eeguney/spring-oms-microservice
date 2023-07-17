package com.ordermanagement.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ordermanagement.orderservice.model.Order;
import com.ordermanagement.orderservice.model.OrderStatus;
import com.ordermanagement.orderservice.repository.OrderRepository;
import com.ordermanagement.orderservice.util.JsonConverterUtil;
import com.ordermanagement.orderservice.util.SendNewOrderToQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RedisTemplate redisTemplate;
    private final JsonConverterUtil jsonConverterUtil;
    private final SendNewOrderToQueue sendNewOrderToQueue;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) throws JsonProcessingException {
        order.setOrderStatus(OrderStatus.ON_HOLD);
        log.info("Order - Adding to database");
//        Order savedOrder = orderRepository.save(order);
        log.info("Order - Sent new order to order processing service");
        return sendNewOrderToQueue.send(order);
    }

}
