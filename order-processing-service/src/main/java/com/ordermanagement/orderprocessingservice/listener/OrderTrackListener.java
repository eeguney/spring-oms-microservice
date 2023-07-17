package com.ordermanagement.orderprocessingservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ordermanagement.orderprocessingservice.model.Order;
import com.ordermanagement.orderprocessingservice.model.OrderStatusDTO;
import com.ordermanagement.orderprocessingservice.repository.OrderRepository;
import com.ordermanagement.orderprocessingservice.util.JsonConverterUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderTrackListener {

    private final RedisTemplate<String, String> redisTemplate;
    private final OrderRepository orderRepository;
    private final JsonConverterUtil jsonConverterUtil;

    @RabbitListener(queues = "order.order-track-queue.queue")
    public void orderTrackListener(Order order) throws JsonProcessingException {
        log.info("New order (id:"+order.getOrderId()+ ") in process...");
        order.setOrderStatus(OrderStatusDTO.IN_PROCESS);
        log.info("Save new order (id:"+order.getOrderId()+ ") to database...");
        Order savedOrder = orderRepository.save(order);
        log.info("Save new order (id:"+order.getOrderId()+ ") to cache...");
        redisTemplate.boundValueOps("order-" + order.getOrderId()).set(jsonConverterUtil.execute(savedOrder));
    }

}
