package com.ordermanagement.ordertrackservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ChangeOrderStatusRequest {
    private String orderId;
    private OrderStatus orderStatus;
}
