package com.ordermanagement.orderservice.util;

import com.ordermanagement.orderservice.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class SendNewOrderToProcessingService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${properties.order-processing-service}")
    private String orderProcessingServiceUrl;

    public Order send(Order order) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Order> httpEntity = new HttpEntity<Order>(order,headers);
        ResponseEntity<Order> response =
                restTemplate.exchange(
                        orderProcessingServiceUrl,
                        HttpMethod.POST,
                        httpEntity,
                        Order.class
                );
        if(response.getStatusCode().isError()) {
            log.info("New Order - Sending new order to processing service is failed.");
            return null;
        } else {
            log.info("New Order - New order has been sent to processing service");
            return response.getBody();
        }
    }
}
