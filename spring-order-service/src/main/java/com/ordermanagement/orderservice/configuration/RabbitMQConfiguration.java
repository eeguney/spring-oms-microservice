package com.ordermanagement.orderservice.configuration;

import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class RabbitMQConfiguration {

    @Value("${queues.order-track-queue.queue}")
    private String orderTrackQueueName;

    @Value("${queues.order-track-queue.routing}")
    private String orderTrackRoutingName;

    @Value("${queues.order-track-queue.exchange}")
    private String orderTrackExchangeName;

    @Bean
    public Queue orderTrackQueue() {
        return QueueBuilder
                .durable(orderTrackQueueName)
                .build();
    }

    @Bean
    public DirectExchange orderTrackExchange() {
        return new DirectExchange(orderTrackExchangeName);
    }

    @Bean
    public Binding orderTrackBinding() {
        return BindingBuilder
                .bind(orderTrackQueue())
                .to(orderTrackExchange())
                .with(orderTrackRoutingName);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}