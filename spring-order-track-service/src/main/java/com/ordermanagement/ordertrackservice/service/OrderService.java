package com.ordermanagement.ordertrackservice.service;

import com.ordermanagement.ordertrackservice.model.ChangeOrderStatusRequest;
import com.ordermanagement.ordertrackservice.model.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${properties.order-service}")
    private String orderServiceUrl;

    @Value("${properties.order-processing-service}")
    private String orderProcessingServiceUrl;

    public List<OrderDTO> getAllOrders() {
        log.info("Requesting to order processing service for all orders...");
        ResponseEntity<OrderDTO[]> orders = restTemplate.exchange(orderServiceUrl,
                HttpMethod.GET,
                null,
                OrderDTO[].class
        );

        return Arrays.asList(orders.getBody());
    }

    public OrderDTO createOrder(OrderDTO order) {
        log.info("Requesting to order processing service for create new order...");
        HttpEntity<OrderDTO> orderRequest = new HttpEntity<>(order);
        var orders = restTemplate.exchange(orderServiceUrl,
                HttpMethod.POST,
                orderRequest,
                new ParameterizedTypeReference<OrderDTO>() {
                }
        );
        return orders.getBody();
    }

    public boolean changeOrderStatus(ChangeOrderStatusRequest request) {
        log.info("Requesting to order processing service for change order status...");
        HttpEntity<ChangeOrderStatusRequest> orderRequest = new HttpEntity<>(request);
        boolean orders = restTemplate.exchange(orderProcessingServiceUrl,
                HttpMethod.POST,
                orderRequest,
                new ParameterizedTypeReference<Boolean>() {
                }
        ).getBody();
        return orders;
    }

}
