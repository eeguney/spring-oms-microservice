package com.ordermanagement.orderprocessingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeOrderStatusRequest {
    private String orderId;
    private OrderStatusDTO orderStatus;
}
