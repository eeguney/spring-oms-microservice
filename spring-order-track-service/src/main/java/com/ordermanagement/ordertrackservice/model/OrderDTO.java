package com.ordermanagement.ordertrackservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderDTO {
    private String orderId;

    private String customerId;

    private List<ProductDTO> products;

    private Integer totalPrice;

    private OrderStatus orderStatus;

    private Date orderDate;
}
