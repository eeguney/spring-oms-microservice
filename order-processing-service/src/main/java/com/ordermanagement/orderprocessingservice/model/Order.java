package com.ordermanagement.orderprocessingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    private String orderId;

    private String customerId;

    private List<ProductDTO> products;

    private Integer totalPrice;

    private OrderStatusDTO orderStatus;

    @CreatedDate
    private Date orderDate;


}
