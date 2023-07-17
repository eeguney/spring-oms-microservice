package com.ordermanagement.orderservice.util;

import com.ordermanagement.orderservice.configuration.RabbitMQConfiguration;
import com.ordermanagement.orderservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SendNewOrderToQueue {

    private final RabbitTemplate rabbitTemplate;

    private final RabbitMQConfiguration rabbitMQConfiguration;

    public Order send(Order order) {
        rabbitTemplate.convertAndSend(
                rabbitMQConfiguration.getOrderTrackExchangeName(),
                rabbitMQConfiguration.getOrderTrackRoutingName(),
                order
        );
        return order;
    }

}
