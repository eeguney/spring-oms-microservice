package com.ordermanagement.orderservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String orderId;

    private String customerId;

    private List<ProductDTO> products;

    private Integer totalPrice;

    private OrderStatus orderStatus;

    private Date orderDate;


}
